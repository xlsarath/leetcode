import java.util.TreeSet;

public class LargestProduct {
	public static int maxProduct(int[] nums){
		TreeSet<Integer> set = new TreeSet<Integer>();
		int max = 0;
		for(int i = 0; i < nums.length; i++){
			Integer pre = set.lower(nums[i]);
			set.add(nums[i]);
			if(pre != null){
				max = Math.max(pre * nums[i], max);
			}
		}
		return max;
	}
	
	public static int recur(int[] nums, int n){
		int t = 0;
		if(n == 1){
			return(nums[0]);
		}else{
			t = recur(nums, n - 1);
			if(nums[n - 1] > t){
				return nums[n - 1];
			}else{
				return t;
			}
		}
	}
	
	public static void main(String[] args){
		int[] nums = {10, 8, 9, 7, 20, 6};
		System.out.println(recur(nums, nums.length));
		System.out.println(11);
	}
}