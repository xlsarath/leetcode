/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
                
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode first = head, second = dummyHead;
        
        while(n > 0){
            first = first.next; 
            n--;
        }
        
        while(first != null){
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        
        return dummyHead.next;
    }
}