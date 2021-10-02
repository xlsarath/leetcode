class Solution {
  
    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String,PriorityQueue<String>> map =  new HashMap<>();
        
        
        
        for(List<String> l : tickets){
            map.putIfAbsent(l.get(0), new PriorityQueue<>());
            PriorityQueue<String> pq = map.get(l.get(0));
            pq.offer(l.get(1));
        }
        
        List<String> res = new ArrayList<>();
        
        
        dfs("JFK",map,res); 
        
        Collections.reverse(res);
        
        return res;
    }
    
    
    public void dfs(String s, HashMap<String,PriorityQueue<String>> map, List<String> res){

       
        
       PriorityQueue<String> pq = map.get(s);

                
       while(pq != null && !pq.isEmpty()) {
           String temp = pq.poll();
           dfs(temp,map,res); 
       }  
                    res.add(s);

   
    }
    
 ////stk : 
    
    //res : ATL JFK SFO JFK
      
}