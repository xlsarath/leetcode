import java.util.*;

public class Longest_Airthmetic_SubSequence {

        public int longestArithSeqLength(int[] A) {
            
    Map<Integer,Integer> dp[] = new HashMap[A.length];
            for(int i=0;i<A.length;i++)
                dp[i] = new HashMap<>();
            int max = 1;
            for(int i=1;i<A.length;i++){
                for(int j=0;j < i;j++){
                    int diff = A[i] - A[j];
                    dp[i].put(diff, dp[j].getOrDefault(diff,0)+1);
                    max = Math.max(max,dp[i].get(diff));
                }
            }
            return max+1;
        }
    }
    
      