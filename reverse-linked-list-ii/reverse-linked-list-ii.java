/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(left == right) return head;
         ListNode prev1 = null;
         ListNode current1 = head;
         ListNode leftref = head;
         int count = 1;

        if(left != 1){
            while(current1 != null){
                prev1 = current1;
                current1 = current1.next;
                count++;
                if(count == left){
                    leftref = current1;
                    prev1.next = null;
                  //  System.out.println("leftref "+leftref.val+" prev1 "+prev1.val);
                    break;
                }
            }
        
        } 
        ListNode next = null;
            
        while(current1 != null){

            current1 = current1.next;
            count++;
            if(count == right){
                next = current1.next;
                current1.next = null;
                break;
            }
        }
        
        ListNode rev = reverse(leftref);

        
        
        if(prev1 == null){
            leftref.next = next;
            return rev;
        } 
        
       // System.out.println("rev"+rev.val+"leftref"+leftref.val+" prev1 "+prev1.val);
        prev1.next = rev;
        leftref.next = next;
        
        return head;
        
    }
    
    public ListNode reverse(ListNode node){
        
        if(node == null || node.next == null) return node; 
        
        ListNode temp = reverse(node.next);
        node.next.next = node;
        node.next = null;
        
        return temp;
    }
}