public class SortArrayByIncreasingFrequency_1636 {
    
        public int[] frequencySort(int[] nums) {
            
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
           for(int num : nums){
               if(map.containsKey(num)){
                   map.put(num, map.get(num)+1);
               } else {
                   map.put(num, 1);
                   list.add(num);
               }
           }
            
            Collections.sort(list, (a,b) -> (map.get(a) == map.get(b) ? (b - a) : map.get(a) - map.get(b)));
            
            int k = 0;
    for(int num : list){
            int count = map.get(num);
        while(count > 0){
            nums[k++] = num;
            count--;
        }
    }
            
            return nums;
            
        }
    
}
