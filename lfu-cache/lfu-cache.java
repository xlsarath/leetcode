class LFUCache {
    
    class DLList{
        
        Node head, tail;
        int size;
            
        DLList(){
            
            head = new Node(0,0);
            tail = new Node(0,0);
            
            head.next = tail;
            tail.prev = head;
            
            this.size = size;
        }
        
        public void addFirst(Node node){
            
            Node headRef = head.next;
            
            head.next = node;
            node.prev = head;
            
            node.next = headRef;
            headRef.prev = node;
            size++;
            
        }
        
        public void remove(Node node){
            Node nextNode = node.next;
            Node prevNode = node.prev;
            
            nextNode.prev = prevNode;
            prevNode.next = nextNode;
            size--;
        }
        
        
        public Node removeLast(){

            Node tailNode = tail.prev;
            remove(tailNode);
            return tailNode;
        }
        
    }
    
    
    
    class Node{
        
        Node next, prev;
        int key, val, frequency;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    HashMap<Integer,Node> map;
    HashMap<Integer, DLList> freqMap;
    int min;
    int capacity;
    int size;
    
    public LFUCache(int capacity) {
        
        map = new HashMap<>();
        this.capacity = capacity;
        min = Integer.MAX_VALUE;
        size = 0;
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node != null){
            update(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(capacity == 0)return;
        
        Node node = map.get(key);
        
        if(node != null){
            node.val = value;
            update(node);
            return;
        }
        
        node = new Node(key,value);
        if(size == capacity){
            DLList priorList = freqMap.get(min);
            Node removed = priorList.removeLast();
            map.remove(removed.key);
            size--;
        }
        
        DLList newList = freqMap.get(1);
        if(newList == null){
            newList = new DLList();
            freqMap.put(1, newList);
        }
        
        newList.addFirst(node);
        map.put(key,node);
        min = 1;
        size++;
          
    }
    
    
    public void update(Node node){
        
        DLList priorList = freqMap.get(node.frequency);
        priorList.remove(node);
        
        if(priorList.size==0){
            if(node.frequency == min){
                min++;
            }
        }
        node.frequency++;
        DLList newList = freqMap.get(node.frequency);
        if(newList == null){
            newList = new DLList();
            freqMap.put(node.frequency,newList);
        }
        newList.addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */