/**
Time compplexity :  O(n)
Space Complexity : O(1)


sum : sum of all  numbers
m : no of moves
n : total elements
x : after m moves final number is x
s   um + m * (n - 1) = x * n
actual x = minNum + m
    sum+ m*n -m = n*minNum+n*m
    sum - minNum * n = m

*/
class Solution {
    public int minMoves(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length; i++)
            min = Math.min(nums[i],min);
        
        int moves = 0;
        for(int i = 0 ; i < nums.length; i++)
            moves += nums[i] - min;
        
        return moves;
    }
}




