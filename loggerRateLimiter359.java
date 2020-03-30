import java.util.HashMap;
//time complexity : O(1);
//space complexity : O(1);
//steps used CLL circular linked list, if new message appeares it's added towards head. old messages will be deleted from tail.

class loggerRateLimiter359{

class Node {

    public String message;
    public int timestamp;
    public Node next,prev;

    public Node(int timestamp,String message){
        this.message = message;
        this.timestamp = timestamp; 
    }
}

public HashMap<String,Node> map ;
public Node head;
public Node tail;
public final int MAX_TIME =10;
public loggerRateLimiter359(){
    map = new HashMap<String,Node>();
    head= tail= new Node(0,"");
    head.next = tail;
    tail.prev = head; 
}

public boolean shouldPrintMessage(int timestamp,String message){
    if(map.containsKey(message)){
        Node temp = map.get(message);
        if(timestamp-temp.timestamp < MAX_TIME) return false;
        movetoHead(temp,timestamp);
    }
    else {
        if(map.size()>=MAX_TIME){
            removeTail();
        }
        addtoHead(timestamp,message);
    }
    return true;
}

public void addtoHead(int timestamp,String message){
    Node newNode = new Node(timestamp,message);
    newNode.next = head.next;
    head.next = newNode;
    newNode.prev = head;
    newNode.next.prev = newNode;
    map.put(message, newNode);
}

public void removeTail(){
    this.tail.prev.next =  this.tail.next;
    this.tail.next.prev = this.tail.prev;
    map.remove(this.tail.message);
}

public void movetoHead(Node temp, int timestamp){
temp.timestamp =  timestamp;
temp.prev.next =  temp.next;
temp.next.prev = temp.prev;
temp.next = head.next;
temp.prev = head;
head.next =  temp;
temp.next.prev = temp;
}

}