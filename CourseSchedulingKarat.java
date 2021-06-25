import java.util.*;
// course scheduling karat 
public class CourseSchedulingKarat {

        public String[] findOrder(String[][] prerequisites) {
          
            boolean isPossible = true;
          Map<String, String> adjList = new HashMap<String,String>();
          HashMap<String,Integer> indegree = new HashMap();
      
          for (int i = 0; i < prerequisites.length; i++) {
            String dest = prerequisites[i][0];
            String src = prerequisites[i][1];
            adjList.put(src, dest);
              }

          Queue<String> queue = new LinkedList<>();

          for(String val : adjList.values()) 
             {
              if(!adjList.containsKey(val)) queue.add(val);
              }
            
          

        

          int permutations = (adjList.size())/2 + 1; 
          int counter = 0;
          while(!queue.isEmpty()){
            String subject = queue.poll();
            for(String str : adjList.keySet()){
                if(adjList.get(str).equals(subject)){
                queue.add(str);
                counter++;
                }
            }

            if(counter == permutations) return new String[]{subject};
          }

          
          return new String[]{"null"};
        }


      


public static void main(String args[]){

    CourseSchedulingKarat cs = new CourseSchedulingKarat();
    String[][] pairs = {{"DS","A"},{"FS","OS"},{"CN","CA"},{"A","FS"},{"CA","DS"},{"SD","CN"}};

    for(String sub : cs.findOrder(pairs))
        System.out.println(" "+sub);
 

}

}


