//time complexiy : O(n)
//space complexity : O(1)
//leet code : yes
// steps : initialse two pointers, ensure 2nd pointer maintains distance 'n' from 1st .as first pointer meets lastnode. 2nd will be right b4 the node that needs to be deleted. now assign node.next.next to second pointer and return head;
class RemoveNthNodeFromEndofList {

class ListNode {
    ListNode next;
int val;
    ListNode(int x){
        this.val =x;
    }
}

public ListNode removeNthFromEnd(ListNode head, int n) {
ListNode dummyHead = new ListNode(0);
dummyHead.next = head;

ListNode first=head,second=dummyHead;
int count = n; 
while(count>0){
    first = first.next;
    count--;
}

while(first!=null){
    first = first.next;
    second = second.next;
}

second.next = second.next.next;

return dummyHead.next;

}



}