/**
 * time complexity :  O(n)
 * space complexity : O(1)
 * leet code execution successfull
 * Steps: 1) run the loop for array length
 *         2) while traversing through loop verify if the computed sum for every iteration minus K returns element in hashset.
 *         3) if element exist increment count with get value,else place sum into hashmap. 
 *          4) once loop completes the count will have total subarray count.
 */

import java.util.HashMap;

class SubArraySumEqualsK{

    public int findSubArray(int arr[], int k){

        if(arr==null||arr.length==0)
            return 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int reSum=0,count=0;
        for(int i=0;i<arr.length;i++){
        reSum += arr[i];
        int compliment = reSum-k;
        if(map.containsKey(compliment))
            count += map.get(compliment);
        if(!map.containsKey(reSum))
            map.put(reSum, 1);
        else
            map.put(reSum,map.get(reSum)+1);

        }
       return count;
    }


public static void main(String[] args) {
    SubArraySumEqualsK sk = new SubArraySumEqualsK();
    int arr[] = {1,1,1,1,1,1,1,1,2,2,2,3,3,4,4,3,2,2,2};
    int k = 4;
    System.out.println(sk.findSubArray(arr, k));
    
}



}