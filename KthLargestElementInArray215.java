import java.util.PriorityQueue;

class KthLargestElementInArray215 {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums==null || nums.length==0) return 0;
        
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        
        for(int i=0;i<k;i++){
            minHeap.add(nums[i]);
        }
        
        for(int i=k; i< nums.length; i++){
            if(nums[i] > minHeap.peek()){
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }


    public static void main(String[] args) {
        KthLargestElementInArray215 klea = new KthLargestElementInArray215();
        int nums[] = {1,2,3,4,5,9,66,44};
        System.out.println(klea.findKthLargest(nums, 2));
    }
}