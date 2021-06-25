import java.util.Arrays;
//time complexity : Overall --DP n^2 ... for sorting ..n logn 
//spsce complexity : O(1)
//leet cod : yes
//steps :  DP
public class RussianDollEnvelopes354 {

        public int maxEnvelopes(int[][] envelopes) {
            
            if(envelopes == null || envelopes.length == 0) return 0;
            int n = envelopes.length;
            int output[] = new int[n];
            
            Arrays.sort(envelopes, (int[] a, int[] b) -> (a[0] - b[0]));
            Arrays.fill(output,1);
            
            int maxLength = 0;
            
            for(int i = 0 ; i < n; i++){
                for(int j = i-1 ; j >= 0; j--){
                    if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                        output[i] = Math.max(output[i], 1 + output[j]);
                    }
                }
                maxLength = Math.max(maxLength, output[i]);
            }
            
            return maxLength;
        }
    }