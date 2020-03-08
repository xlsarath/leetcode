import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
            
        HashMap <Integer,List<Integer>> graph = new HashMap<>();
        
        for(int i=0;i<numCourses;i++){
            graph.put(i,new LinkedList<>());
        }
        
        int[] indegree = new int[numCourses];
        
        for(int[] tuple: prerequisites ){
            int course = tuple[0];
            int prerequisite = tuple[1];
        
            graph.get(prerequisite).add(course);
            indegree[course]++;
        }
        int arr[] = new int[numCourses];

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int count =0;
        while(!queue.isEmpty()){
            int currentCourse = queue.poll();
            arr[count] =currentCourse;
            List<Integer> correspondingCourse = graph.get(currentCourse);
            for(int course:correspondingCourse )
            {
                indegree[course]--;
                if(indegree[course]==0){
                    queue.add(course);
                }
            }
            count++;
        }
        if(count==numCourses){
            
            return arr;
        }
        return new int[0];
 
    }
}