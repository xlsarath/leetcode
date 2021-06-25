import java.util.HashSet;
import java.util.PriorityQueue;
//akuna capital
public class RemoveDuplicate {
	public static int[] removeDup(int[] nums){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			set.add(nums[i]);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(Integer num : set){
			pq.add(num);
		}
		int[] res = new int[set.size()];
		for(int i = set.size() - 1; i >= 0; i--){
			res[i] = pq.poll();
		}
		
		return res;
	}
	
	public static void main(String[] args){
		int[] nums = { 2,3 ,4, 4 ,3, 2, 1};
		int[] res = removeDup(nums);
		for(int i = 0; i < res.length; i++){
			System.out.print(res[i]);
		}
	}
}