class MyHashMap {
    
    class Node{
        
        int key, val;
        Node next;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node nodes[];
    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    public int getKey(int key){
        return key%10000;
    }
    
    public Node getElement(int key){
        
        int idx = getKey(key);
        
        Node node = nodes[idx];
        if(node != null){
            while(node.next != null && node.next.key != key)
                node = node.next;
            return node;
        }
            
           Node dummy = new Node(-1,-1);
           nodes[idx] = dummy;
           return dummy; 
        
        
    }
    public void put(int key, int value) {
        
        Node node = getElement(key);
        
        if(node.next != null){
            node.next.val = value;
            return;
        }
        
        Node temp = new Node(key, value);
        node.next = temp;
        
    }
    
    public int get(int key) {
        
        Node node = getElement(key);
        
        if(node.next != null)
            return node.next.val;
       return -1; 
    }
    
    public void remove(int key) {
        
        Node node = getElement(key);
        
        if(node.next != null)
            node.next = node.next.next;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */