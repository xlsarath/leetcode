import java.util.Comparator;
import java.util.PriorityQueue;
//time complexity : NlogK
//space complexity : logN
//leet code : yes
//steps : used priority with custom comparater to maintain ordering
class MergeKsortedLists23{

    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
        }

        public ListNode mergeKLists(ListNode[] lists) {
        
            if(lists==null || lists.length==0) return null;
        
            Comparator<ListNode> customComparator = new Comparator<>() {

                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val ;
                }

            };
            
            PriorityQueue<ListNode> pq = new PriorityQueue<>(customComparator);

            for(ListNode headNode : lists){
                if(headNode!=null) pq.add(headNode);
            }
        
            ListNode result = new ListNode(0);
            ListNode cursor = result;

            while(!pq.isEmpty()){
                ListNode minNode =  pq.poll();
                cursor.next = minNode;
                cursor = minNode;
                if(minNode.next!=null){
                    pq.add(minNode.next);
                }
            }
            return result.next;
        }

}