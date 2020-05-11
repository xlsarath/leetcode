import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAllAnagramsinaString438 {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if(s.length()==0||s==null) return result;
        
        int[] frequencyP = new int[26];
        int[] frequencyWindow = new int[26];
        
        for(int i=0; i< p.length(); i++){
            char ch = p.charAt(i);
            frequencyP[ch-'a']++;
        }
        
        int start=0,end=0;
        
        while(end<s.length()){
            
            char ch = s.charAt(end);
            frequencyWindow[ch-'a']++;
            
            if(end-start+1 > p.length()){
                frequencyWindow[s.charAt(start) - 'a']--;
                start++;
            }
            
            if(Arrays.equals(frequencyWindow,frequencyP)){
                result.add(start);
            }
            end++;
            
        }
        
        return result;
    }

    public static void main(String[] args) {
        FindAllAnagramsinaString438 ss = new FindAllAnagramsinaString438();
        System.out.println(ss.findAnagrams("cbaebabacd", "abc"));
    }
}