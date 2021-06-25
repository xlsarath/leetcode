import java.util.ArrayList;
import java.util.HashMap;

class SparseArrays {

        // Complete the matchingStrings function below.
        static int[] matchingStrings(String[] strings, String[] queries) {
        
                int result[] = new int[queries.length];
    
        
            if(queries.length==0||queries==null) return new int[]{0};
            
            HashMap<String,Integer> map = new HashMap<>();
            for(String s :strings){
                if(!map.containsKey(s)){
                    map.put(s,1);
                } else if (map.containsKey(s)) {
                           map.put(s,map.get(s)+1);
                           }
            }
            
            
            for(int i =0 ; i<queries.length; i++){
                if(map.containsKey(queries[i])){
                    result[i] = map.get(queries[i]);
                }
                else{
                    result[i] = 0;
                }
            }
            
         
            return result;
        }
    
        
public static void main(String[] args) {
    
}    


}