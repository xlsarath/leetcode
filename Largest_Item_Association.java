import java.util.*;

//time complexity : O(E+V)
//space complexity : O(N)

class PairString{

    String first;
    String second;

    public PairString(String first, String second){
        this.first = first;
        this.second = second;
    }
}

public class Largest_Item_Association {

  

    public static List<String> largestItemAssociation(List<PairString> itemAssociation) {

        Map<String, Set<String>> graph = buildGraph(itemAssociation);
        Set<String> seen = new HashSet();
        List<List<String>> connectedItems = buildCOnnectedItems(graph, seen);
        sort(connectedItems);
        return connectedItems.get(0);
    }

    private static Map<String, Set<String>> buildGraph(List<PairString> itemAssociation) {

        HashMap<String, Set<String>> graph = new HashMap<>();

        for(PairString pair : itemAssociation){

            graph.putIfAbsent(pair.first, new HashSet<>());
            graph.get(pair.first).add(pair.second);
            graph.putIfAbsent(pair.second, new HashSet<>());
            graph.get(pair.second).add(pair.first);
        }

        return graph;
    }

    private static void sort(List<List<String>> connectedItems) {

        Collections.sort(connectedItems, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> l1, List<String> l2){
                if(l1.size() != l2.size()) return l2.size() - l1.size();

                else {
                        for(int i = 0; i < l1.size(); i++){
                            if(l1.get(i).equals(l2.get(i))) continue;
                            else return l1.get(i).compareTo(l2.get(i));
                        }
                }
                return 0;
            }
        });

    }

    private static List<List<String>> buildCOnnectedItems(Map<String, Set<String>> graph, Set<String> seen) {

        List<List<String>> connectedItems = new ArrayList<>();

        for(String node : graph.keySet()){
            List<String> list = new ArrayList<>();
            dfs(node,graph,seen, list);
            if(!list.isEmpty()){
                Collections.sort(list);
                connectedItems.add(list);
            }
        }

        return connectedItems;
    }

    private static void dfs(String node, Map<String, Set<String>> graph, Set<String> seen, List<String> list) {

        if(seen.contains(node)) return;

        seen.add(node);
        list.add(node);

        for(String neighbor :  graph.get(node))
                dfs(neighbor, graph, seen, list);
        

    }

    public static void main(String[] args) {
        List<PairString> itemAssociation1 = new ArrayList<PairString>();
            itemAssociation1.add(new PairString("item1", "item2"));
            itemAssociation1.add(new PairString("item3", "item4"));
            itemAssociation1.add(new PairString("item4", "item5"));
            
        
            List<PairString> itemAssociation2 = new ArrayList(){
                {
                    add(new PairString("item1", "item2"));
                    add(new PairString("item3", "item4"));
                    add(new PairString("item4", "item5"));
                    add(new PairString("item6", "item7"));
                    add(new PairString("item6", "item8"));
                }
            };
            List<PairString> itemAssociation3 = new ArrayList(){
                {
                    add(new PairString("item1", "item2"));
                    add(new PairString("item4", "item5"));
                    add(new PairString("item3", "item4"));
                    add(new PairString("item1", "item4"));
                }
            };
            
        
        System.out.println(largestItemAssociation(itemAssociation1)); // Output: [item3, item4, item5]
        System.out.println(largestItemAssociation(itemAssociation2)); // Output: [item3, item4, item5], here we got same size, so have to sort lexicographical.
        System.out.println(largestItemAssociation(itemAssociation3)); // Output: [item1, item2, item3, item4, item5]
    }

}