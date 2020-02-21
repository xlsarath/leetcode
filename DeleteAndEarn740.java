//Time complexity : O(n)
//space complxity : O(n) here n is the max element in the array;
//leet code execution : Successful
//Steps: find the max element in array using a for loop. followed by creation of max+1 size array, and position the values in their respective indices if value exists already add to element at that index.
//        now dp array solution can be implied. For every nums[i] there's a option to take or skip. If its considered the element gets added to next element taken else the items will be skipped and computed with next skip cycle.
// once loop exhausts the skip and take variales will hold the ans. Using Math.max function will yield ans.
class DeleteAndEarn740{

    public int delAndEarn(int[] nums) {

        if(nums==null||nums.length==0) return 0;
        int max = Integer.MIN_VALUE;

        for(int i =0; i<nums.length;i++){
            max = Math.max(max,nums[i]);
        };
        int dp [] = new int[max+1];
        for(int i=0; i<nums.length;i++){
            dp[nums[i]] = dp[nums[i]]+nums[i];
        }
        //[4,5,2,2,1,2]
        //[0,1,6,0,4,5] 
        int skip = 0;
        int take =0;
        for (int i=1;i<dp.length;i++){
            int curr_skip = Math.max(skip,take);
            int curr_take = skip + dp[i];
            skip = curr_skip;
            take = curr_take;
        }
        return Math.max(skip,take);
    }


    public static void main(String[] args) {
        
    }
}