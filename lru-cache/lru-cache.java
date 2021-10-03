class LRUCache {
    
    Node head, tail;
    int capacity;
    HashMap<Integer, Node> map;
    
    class Node{
        
        Node next, prev;
        int key, val;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        
        head = new Node(0,0);
        tail = new Node(0,0);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        Node node = map.get(key);
        
        if(node != null){
            remove(node);
            insertFirst(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        Node node = map.get(key);
        
        if(node != null){
            remove(node);
        }
        
        node = new Node(key,value);
        insertFirst(node);
        map.put(key, node);
            
         if(map.size() > capacity){
             node = tail.prev;
             remove(node);
             map.remove(node.key);
         }    
        
    }
    
    public void remove(Node node){
        
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public void insertFirst(Node node){
        
        Node headRef= head.next;
        
        head.next = node;
        node.next = headRef;
        
        headRef.prev = node;
        node.prev = head;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */