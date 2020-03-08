import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//time complexity : O(n)
//space complexity : O(n)
//leet code : yes
// steps :  1) create HashMap with key courses and intialise list for every course to map its prereq
//          2) mapping courses that can be done if pre-req is cleared 
//          3) topological sorting. after adding indegree weights now add element which is having 0 pre-reqs.
//          4) now iterate hashmap and remove coresponding pre-req from other courses and proceed to next courrse whihc's having 0 indegree. if we're able to iterate through entire courses then yes all courses can be taken.
class CourseSchedule207{

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer,List<Integer>> graph =new HashMap<>();

        //store courses

        for(int i=0;i<numCourses;i++){

            graph.put(i, new LinkedList<>());
        }

        int[] indegree = new int[numCourses];
        //added course and prerequisite relationship
        for(int[] tuple: prerequisites){
            int course = tuple[0];
            int prerequisite = tuple[1];
            
            graph.get(course).add(prerequisite);
            indegree[course]++;
        }

        //topological sorting
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        //queue is having intitiating element

        int count=0;
        while(!queue.isEmpty()){
            int currentCourse = queue.poll();
            List<Integer> correspondingCourse = graph.get(currentCourse);
            for(int course: correspondingCourse){
                indegree[course]--;
                if(indegree[course]==0){
                    queue.add(course);
                }
            }
            count++;
        }
        if(count==numCourses) return true;
        return false;
    }


}