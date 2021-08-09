//time complexity : O(n)
//space complexity : for moore it's O(1), hashMap it's O(n)

public class MajorityElement_169 {

        public static int majorityElement(int[] nums) {
            
            int count=0, ret = 0;
        for (int num: nums) {
            if (count==0)
                ret = num;
            if (num!=ret)
                count--;
            else
                count++;
        }
        return ret;
            /**
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int num : nums){
                map.putIfAbsent(num,1);
                if(map.containsKey(num)){
                    map.put(num, map.get(num)+1);
                }
            }
            
            int count = 0;
            for(int i : map.keySet()){
                count = Math.max(count, map.get(i));
            }
            
                    for(int i : map.keySet()){
                        if(map.get(i) == count)
                            return i;
                    }
            return -1;
            */
        }

        public static void main(String[] args) {
            System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
            System.out.println(majorityElement(new int[]{1,100,100,100,25}));
        }
    
    
}
