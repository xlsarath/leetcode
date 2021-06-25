import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
//time complexity : O(nx2^n)
//space complexity :O(n)
//leet code : yes
//steps : BFS approach
public class RemoveInvalidParantheses301 {

        public List<String> removeInvalidParentheses(String s) {
            
            List<String> result = new LinkedList<>();
            Queue<String> queue = new LinkedList<>();
            
            if(s==null) return result;
            
            boolean shouldExploreNextLevel = true;
            Set<String> visited = new HashSet<>();
            
            queue.offer(s);
            
            
            while(!queue.isEmpty()){
                int levelCount = queue.size();
                for(int i=0; i<levelCount; i++){
                    String current = queue.poll();
                    
                    if(!visited.contains(current)){
                        if(isValid(current)){
                           shouldExploreNextLevel = false;
                            result.add(current);
                        }
                        
                        visited.add(current);
                    if(shouldExploreNextLevel){
                    for (int j=0; j< current.length(); j++){
                        if(Character.isLetter(current.charAt(j))) continue;
                        String child = current.substring(0,j)+current.substring(j+1);
                        queue.offer(child);
                        }
                    }
                }
                    }
                    
                if(!shouldExploreNextLevel) break;
            }
            return result;
            
        }
        
       public boolean isValid(String val){
           int count =0;
           for(int i=0; i<val.length();i++){
               char ch = val.charAt(i);
               
               if(ch=='(') count++;
               if(ch==')') count --;
               
               if(count <0) break;
           }
           return count ==0;
       } 

       public static void main(String[] args) {
           for(String s : new RemoveInvalidParantheses301().removeInvalidParentheses("(a)())()"))
                    System.out.println(s);

       }
    }