class LFUCache {
    
    class Node{
        
        Node next,prev;
        int key, val;
        int frequency;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }
    
    class DLList{
        
        Node head, tail;
        int size;
        
        DLList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            
            head.next =tail;
            tail.prev = head;
        }
        
        public void insertFirst(Node node){
            
            Node headRef = head.next;
            
            node.next = headRef;
            head.next = node;
            
            node.prev = head;
            headRef.prev = node;
            size++;
        }
        
        public Node removeLast(){
            Node removed = tail.prev;
            remove(removed);
            return removed;
        }
        
        public void remove(Node node){
            
            Node prevNode = node.prev;
            Node nextNode = node.next;
            
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
        
    }
    
    HashMap<Integer,Node> map;
    HashMap<Integer, DLList> freqMap;
    int size;
    int capacity;
    int min;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        size = 0;
        this.capacity = capacity;
        min = Integer.MIN_VALUE;
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
        
        node = new Node(key, value);
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
        newList.insertFirst(node);
        map.put(node.key, node);
        min = 1;
        size++;
    }
    
    public void update(Node node){
        
        DLList priorList = freqMap.get(node.frequency);
        priorList.remove(node);
        
        if(priorList.size == 0){
            if(min == node.frequency)
                min++;
        }
        node.frequency++;
        DLList newList = freqMap.get(node.frequency);
        if(newList == null){
            newList = new DLList();
            freqMap.put(node.frequency, newList);
        }
        newList.insertFirst(node);
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */