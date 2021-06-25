import java.util.Arrays;
//time complexity : nlogn 
//space complecity : 1
//leet code : yes
//steps: sort the array n then sum up odd/even indexes. 

public class ArrayPartitionI561 {

    public int arrayPairSum(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i += 2){
            sum += nums[i];
        }
        return sum;
    }

}