//time complexity : O( (n-l) * l) ---> approx O(n-l)
//space complexity : O(n-l)
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences187 {

    public List<String> RobinKarpAlgo(String s){
        if(s == null || s.length() < 10)
             return new ArrayList<>();

         int len = s.length();
         long val = 0;
         int L = 10;
         int base = 11; // choose a prime number
         HashSet<Long> set = new HashSet<>(); 
         HashSet<String> res = new HashSet<>();

         for(int i = 0; i < L; i++) {
             char ch = s.charAt(i);
             val = val*base + (ch-'9'); 
         }
         set.add(val);

         for(int i = 10; i < len; i++) {        
             val = (long)((val-((s.charAt(i-L)-'9') * Math.pow(base, (L-1))))*base + (s.charAt(i)-'9'));
             if(set.contains(val))
                 res.add(s.substring(i-L+1,i+1));
             else
                 set.add(val);
         }

         return new ArrayList<>(res);
    }


    public List<String> findRepeatedDnaSequences(String s) {
        
        HashSet<String> result = new HashSet<>();
        if(s == null) return new ArrayList<>(result);
        int L = 10;
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < s.length() -L + 1; i++ ){
            String val = s.substring(i,i+L);
            
            if(set.contains(val))
                result.add(val);
            else
                set.add(val);
        }
        
        return new ArrayList<>(result);
        
    }
    public static void main(String[] args) {
        for(String s : new RepeatedDNASequences187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
            System.out.println(s);
    }
}