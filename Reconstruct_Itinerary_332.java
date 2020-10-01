import java.util.*;

public class Reconstruct_Itinerary_332 {


    public List<String> findItinerary(List<List<String>> ticket) {


        HashMap<String,PriorityQueue<String>> map = new HashMap<>();
        for(int i = 0 ; i < ticket.size(); i++){

            if(map.containsKey(ticket.get(i).get(0))){
                map.get(ticket.get(i).get(0)).add(ticket.get(i).get(1));
            } else {
                PriorityQueue<String> queue = new PriorityQueue<>();
                queue.offer(ticket.get(i).get(1));
                map.put(ticket.get(i).get(0),queue);
            }
        }

        List<String> result = new ArrayList<>();
        dfs(map,"JFK",result);

        Collections.reverse(result);

        return result;

    }

    private void dfs(HashMap<String, PriorityQueue<String>> map, String string, List<String> result) {

        PriorityQueue<String> temp = map.get(string);
        while(temp != null && !temp.isEmpty()){
            String val = temp.poll();
            dfs(map,val,result);
        }
        result.add(string);
    }
    public static void main(String[] args) {
        List<List<String>> vals= new ArrayList<>();
        vals.add(Arrays.asList(new String[]{"MUC","LHR"}));
        vals.add(Arrays.asList(new String[]{"SFO","SJC"}));
        vals.add(Arrays.asList(new String[]{"JFK","MUC"}));
        vals.add(Arrays.asList(new String[]{"LHR","SFO"}));
        System.out.println(new Reconstruct_Itinerary_332().findItinerary(vals));

    }

}