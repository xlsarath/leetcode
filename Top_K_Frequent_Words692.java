import java.util.*;
//Time complexity : O(nlogk)
//space complexity : O(N)
public class Top_K_Frequent_Words692 {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> map = new HashMap<>();

        for(String word : words)
            map.put(word,map.getOrDefault(word,0)+1);

        PriorityQueue<String> heap = new PriorityQueue<String>(
            (w1,w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));

        for(String word : map.keySet()){
            heap.offer(word);
            if(heap.size() > k) heap.poll();
        }

        List<String> result = new ArrayList<>();
        while(!heap.isEmpty())
                result.add(heap.poll());

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        List<String> res =  new Top_K_Frequent_Words692().topKFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
                System.out.println(res);
    }

}