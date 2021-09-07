//https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/

public class MinimumSubArrayToMakeArraySorted {
    
    
    //  int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
    //sol :  sort from index 3 to 8, to make entire array sorted.
  
  // Time complexity : O(n)
  //space : O(1)
    
    public static int[] helper(int[] arr){
        
        int start = 0, end = 0;
        
        //find start
        for(int i = 0 ; i < arr.length - 1; i++){
            if(arr[i] > arr[i+1]){
                start = i;
                break;
            }
        }
        
        if(start == arr.length) return new int[]{-1, -1};
        
        //find end     
        for(int i = arr.length - 1; i >= 0 ; i--){
            if(arr[i] < arr[i - 1]){
                end = i;
                break;
            }
        }
        
        //Max and Min with in subarry.
        int max = arr[start],  min = arr[start];
        for(int i = start + 1; i <=end; i++){
            if(arr[i] > max)
                max = arr[i];
            if(arr[i] < min)
                min = arr[i];
        }
        
        //re-adjust start;
        for(int i = 0 ; i < start; i++){
            if(arr[i] > min){
                start = i;
                break;
            }
        }
        
        //re-adjust end;
        for(int i = arr.length - 1; i >= end; i--){
            if(arr[i] < max){
                end = i;
                break;
            }
        }
        
        return new int[]{start, end};
    }
    
    public static void main(String[] args) {
         int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int arr1[] = {1,2,3,10,7,6,15,16};
        System.out.println(Arrays.toString(helper(arr)));
        System.out.println(Arrays.toString(helper(arr1)));
    }
}
