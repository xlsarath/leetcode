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
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null || head.next.next == null) return;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
         ListNode mid;
        if(fast.next != null){//even
          mid = reverse(slow.next);
          prev.next.next = null;  
        }
        else{
            mid = reverse(slow.next);
            prev.next.next= null;
        }
        
        
        ListNode current = new ListNode(-1);
        ListNode Thead = current;
        ListNode headRef = null;
        while(mid!= null && head != null){
            
            
            ListNode midHeadRef = mid.next; 
             headRef = head.next; 
            
            current.next = head;
            head.next = null;
            current.next.next = mid;
            mid.next = null; 
           
            head = headRef;
            mid = midHeadRef;
            current = current.next.next;
            
        }
        
        current.next = headRef;
        
        
        head = Thead.next;
         
    
        
    
    }
    
    
    public ListNode reverse(ListNode head){
        
        if(head == null || head.next == null) return head;
        
        ListNode reverse = reverse(head.next);
        head.next.next = head;
        head.next =null;
        
        return reverse;
    }
}