//time complexity : O(n)
//space complexity : O(1)
//leet code : yes
//steps : intialze two pointers slow and fast at headnode. run slow pointer at 1x and fast pointer at 2x. when they both meet reset slow to head and chage pace for both slow and fast to 1x. wherever they meet return the node.
class LinkedListCycleII142{

    class ListNode{

        ListNode next;
        int val;

        ListNode(int x){
            this.val = x;
        }
    }

    public ListNode detectCycle(ListNode head) {
    
        ListNode slow = head,fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                slow = head;
                while(slow!=fast){
                    slow= slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    
    }


}