class Solution {

    //Time complexity :O(N^2 * A^N + D), where N is number of dials (4 in our case), A is number of alphabet (10 in our case), D is size of deadends.
    //Space complexity : O(A^N), in worst case equal to number of combinations.

    public int openLock(String[] deadends, String target) {
      
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        
                 if (set.contains("0000")) return -1;

        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String temp = q.poll();
                //System.out.println(temp);

                if(temp.equals(target)) return steps;
                
                for(String neighbor: neighbors(temp)){
                    if(set.contains(neighbor)) continue;
                    set.add(neighbor);
                    q.offer(neighbor);
                    
                }
                
            }
            
           steps++;

        }
        
        return -1;
    }
    
    List<String> neighbors(String str){
        
        List<String> list = new ArrayList<>();

        for(int i = 0 ; i < 4; i++){
            
            int x = str.charAt(i) - '0';
            for(int diff = -1; diff <= 1; diff += 2){
                int y = (x + diff + 10) % 10;
                list.add(str.substring(0,i)+(""+y)+str.substring(i+1));
                
            }
            
        }


        return list;
    }
}