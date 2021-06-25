import java.util.*;
//time complexity : O(V + E) 
//space complexity : O(V)
public class Accounts_Merge_721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, HashSet<String>> map = new HashMap<>();

        for(List<String> list : accounts){
            for(int i = 1 ; i < list.size(); i++){
                if(!map.containsKey(list.get(i))) map.put(list.get(i), new HashSet<String>());
                map.get(list.get(i)).add(list.get(1));
                map.get(list.get(0)).add(list.get(0)); 
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList();
        for(List<String> list : accounts){
            if(!visited.contains(list.get(1))){
                    List<String> state  =  new ArrayList<>();
                    dfs(map, visited, list.get(1),state);
                    Collections.sort(state);
                    state.add(0,list.get(0));
                    result.add(state);
            }

        }
        return result;
    }

    private void dfs(Map<String, HashSet<String>> map, Set<String> visited, String str, List<String> state) {

        visited.add(str);
        state.add(str);

        for(String s : map.get(str)){
            if(!visited.contains(s))
                    dfs(map,visited,s,state);
        }

    }

    public void bfs(Map<String,Set<String>> graph, Set<String> visited, String s,List<String> ans){
        Queue<String> q=new LinkedList<>();
        q.add(s);
        visited.add(s);
        while(!q.isEmpty()){
            String t=q.poll();
            ans.add(t);
            for(String str:graph.get(t)){
                if(!visited.contains(str)){
                    q.add(str);
                    visited.add(str);
                } 
            }
        }
    }


}