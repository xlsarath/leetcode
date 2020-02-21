class HashMapImplementation{

Node nodes[];

class Node{
    int key,value;
    Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;

    }
}

public HashMapImplementation(){
    nodes = new Node[10000];
}

public int getIndex(int key){
    return key%10000;
}

public Node getElement(int key){
    int index = getIndex(key);

    if(nodes[index]==null){
        Node dummy = new Node(-1,-1);
        nodes[index]=dummy;
        return dummy;
    }

    Node cursor = nodes[index];
    while(cursor!=null && cursor.next.key!=key){
        cursor = cursor.next;
    }
    return cursor;
}

public int get(int key){
    Node cursor = getElement(key);

    if(cursor.next==null){return -1;}

    return cursor.next.value;
}

public void put(int key,int value){
    Node cursor=getElement(key);

    if(cursor.next==null) {
        Node node = new Node(key, value);
        cursor.next=node;
        return;
    }
    cursor.next.value = value;
}

public void remove(int key){
    Node cursor=getElement(key);
    if(cursor.next!=null){
        cursor.next=cursor.next.next;
    }
}

}