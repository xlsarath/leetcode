//time complexity : O(n)
//space complexity : O(1)
//leetcode : yes
//steps : reversed from mid and crossverified each element at a time in both list..if every element matches and able to reach last point then it's palindrome.

class PlaindromeLinkedList234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
  
    public boolean isPalindrome(ListNode head) {
        
        if(head==null||head.next==null) return true;
        
        ListNode mid = findMid(head);
        ListNode reverseList = getReverse(mid.next);
        
     
        
        while(reverseList != null){
            if(reverseList.val != head.val)return false;
            reverseList = reverseList.next;
            head = head.next;
            
        }
        
        return true;
    
        
    }
    
    public ListNode getReverse(ListNode mid){ 
        if(mid==null||mid.next==null)return mid;        
        ListNode R = getReverse(mid.next);
        mid.next.next=mid;
        mid.next=null;
        return R;
       
        
     
    }
    
    
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast =head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
        }
        
        return slow;
    }
}