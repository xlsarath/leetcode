import java.util.LinkedList;
import java.util.List;
//time complexity : O(n)
//space complexity : O(n)
//steps : greedy approach
//leet code : yes
class PartitionLabels763 {
    
public List<Integer> partitionLabels(String s) {
        
        List<Integer> result = new LinkedList<>();
        int lastIndex[] = new int[26];
        
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }
        
        int start =0,end=0;
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            end = Math.max(end,lastIndex[ch-'a']);
            
            if(i==end){
                result.add(end-start+1);
                start=i+1;
                //end = i+1;
                    
            }
        }
        
        return result;
    }
public static void main(String[] args) {
    for(int i : new PartitionLabels763().partitionLabels("ababcbacadefegdehijhklij")) System.out.println(i);
}
}