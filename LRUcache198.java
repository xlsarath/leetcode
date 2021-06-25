import java.util.HashMap;
// time complexity : O(1)
//space complexity O(k) .. k is cap
//leet code : yes
//steps : used additonal hashmap and doubly linked list to attain LRU cache


class LRUcache198 {

    Node head,tail;
    int capacity;
    HashMap<Integer,Node> map;

    class Node{

        Node prev,next;
        int key,value;

        Node(int key, int value){
            this.key =key;
            this.value = value;
        }

    }


    
    public LRUcache198(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next =tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        Node cursor = map.get(key);
        if(cursor!=null){
            remove(cursor);
            insertFirst(cursor);
            return cursor.value;
        }
        return -1;
    }
    


    public void put(int key, int value) {
        
        Node cursor = map.get(key);
        if(cursor!=null){
            cursor.value = value;
            remove(cursor);
        }

        cursor = new Node(key,value);
        insertFirst(cursor);
        map.put(key, cursor);
        if(map.size()>capacity){
            cursor = tail.prev;
            remove(cursor);
            map.remove(cursor.key);
        }

    }

    private void insertFirst(Node cursor) {

        Node firstNode = head.next;
        head.next = cursor;
        firstNode.prev= head;

        cursor.next =  firstNode;
        firstNode.prev = cursor;
    }

    private void remove(Node cursor) {
    Node prevNode = cursor.prev;
    Node nextNode = cursor.next;
    prevNode.next= nextNode;
    nextNode.prev = prevNode;
    
    }   

}