/**
Time complexity : O(n*l) --> l is num of duplicates in the map
Space complexity : O(n) 

Input:
[1, 2, 1, 1, 2, 3]
Output:
[5, 3, 3, 4, 3, 0]
Explanation:
The element 0 = 1. Similar elements are at indices 2 and 3.
The distance metric for element 0 = | 0 - 2 | + | 0 - 3 | = 5
Similar logic follows:
The distance metric for element 1 = | 1 - 4 | =3
The distance metric for element 2 = | 2 - 0 | + | 2-3 | = 3
The distance metric for element 3 = | 3 - 0 | + | 3 - 2 | = 4
The distance metric for element 4 = | 4 - 1 | = 3
The distance metric for element 5 = 0
Thus, distance metrics=[5, 3, 3, 4, 3, 0]
*/
public class Main {
    
    public static int[] distanceInArray(int nums[]){
        
       int res[] = new int[nums.length]; 
       HashMap<Integer, List<Integer>> map = new HashMap<>();
      for(int i = 0; i < nums.length; i++){
          map.putIfAbsent(nums[i], new ArrayList<>());
          map.get(nums[i]).add(i);
      } 
              
      for(int i = 0 ; i < nums.length; i++){
          int sum = 0;
          for(int num : map.get(nums[i]))
                  sum += Math.abs(i - num);          
          res[i] = sum;
      }  
      return res;  
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] nums = {1, 2, 1, 1, 2, 3};
        int[] nums1 = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(distanceInArray(nums)));
        System.out.println(Arrays.toString(distanceInArray(nums1)));
    }
}
