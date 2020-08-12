import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Copy_Lisst_With_Random_Pointer_138 {

    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
  
  Map<Node, Node> map = new HashMap<Node, Node>();
  
  // loop 1. copy all the nodes
  Node node = head;
  while (node != null) {
    map.put(node, new Node(node.val));
    node = node.next;
  }
  
  // loop 2. assign next and random pointers
  node = head;
  while (node != null) {
    map.get(node).next = map.get(node.next);
    map.get(node).random = map.get(node.random);
    node = node.next;
  }
  
  return map.get(head);
        
        
    }
}