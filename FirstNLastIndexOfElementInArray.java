/* 
 1) time complexity is O(log n)
 2) Space Complexity : O(1)
 3) Did this code successfully run on Leetcode : Yes
 4)Steps:
    - created a method signature that returns last most/right most index of element in an array
    - to get last index used binary search to compute mid.
    - the condition to return mid is when target element is >= to it's predecessor and less than to right element
    - base condtions are verified to check if it's 1st/last most/size of array and non-existent element check. 

*/

class FirstNLastIndexOfElementInArray {
        public int[] searchRange(int[] nums, int target) {
            
            if(nums==null || nums.length ==0){
                return new int[]{-1, -1};
            }
            
            int first = rightIndex(nums,target-1);
            int last = rightIndex(nums,target);
            
            if(first==last){
                return new int[]{-1,-1};
            }
            
            return new int[]{first+1,last};
        }
        
        public int rightIndex(int []arr,int target){
            int low =0;
            int high = arr.length-1;
            
            if(target < arr[0]){
                return -1;
            }
            
            if(target>=arr[arr.length-1]){
                return arr.length-1;
            }
            
            while(low<=high){
                int mid = low + (high-low)/2;
                if(arr[mid] <= target && arr[mid+1]>target){
                    return mid;
                }
                if(arr[mid]<=target){
                    low = mid +1;
                }
                else {
                    high = mid -1;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            FirstNLastIndexOfElementInArray fn = new FirstNLastIndexOfElementInArray();
            int arr[] = {1,1,1,1,1,1,1,2,2,2,2,2,3,3,4};
            System.out.println(fn.searchRange(arr,3)[0]+" "+fn.searchRange(arr,3)[1]);
        }
        
    }

