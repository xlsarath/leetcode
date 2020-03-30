import java.util.ArrayList;
import java.util.List;
//time complexity : O(logn)
//space complexity : k
//leet code yes;
//steps : implemeted using binarysearch
class FindKClosestElements658 {

    public List<Integer> findClosestElements(int[] nums, int k, int x) {
    
        List<Integer> result = new ArrayList<>();

        if(nums==null||nums.length==0) return result;

        int low  = 0;
        int high = nums.length-k;
        
        while(low<high){
            int mid = low + (high-low)/2;
            if(Math.abs(x-nums[mid]) > Math.abs(nums[mid+k]-x)){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        for(int i=0; i<k; i++){
            result.add(nums[low+i]);
        }
        return result;
    }


    public static void main(String[] args) {
        FindKClosestElements658 fce = new FindKClosestElements658();
        int arr[] = {1,2,3,4,5,6,7};

        for (int i : fce.findClosestElements(arr, 4, 5)) System.out.println(i);
    }

}