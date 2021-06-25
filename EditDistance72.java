//time complexity : O(m x n) ..length of string1 and 2
//space complexity : O(m x n)
// leet code : yes
//steps : implemeted using DP.

public class EditDistance72 {

        public int minDistance(String word1, String word2) {
       // return minDist(word1, word1.length(), word2, word2.length());
        
            int dp[][] = new int[word1.length()+1][word2.length()+1];
            
            for(int i=0; i <= word1.length(); i++){
                dp[i][0] = i;
            }
            
            for(int j=0; j<= word2.length(); j++){
                dp[0][j] = j;
            }
            
            for(int i=1; i<= word1.length(); i++){
                for(int j=1; j<= word2.length(); j++){
                    if(word1.charAt(i-1)==word2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1],dp[i-1][j-1]),dp[i-1][j]);
                    }
                }
            }
        return dp[word1.length()][word2.length()];
        }
        /** 
        private int minDist(String x, int i, String y, int j  ){
            
            if(i==0) return j;
            if(j==0) return i;
            
            if(x.charAt(i-1)==y.charAt(j-1)) return minDist(x, i-1, y, j-1);
            
            return 1 + Math.min(Math.min(
                                (minDist(x, i, y, j-1)),
                                (minDist(x, i-1, y, j-1))),
                                (minDist(x, i-1, y, j)));
            
            
        }

        */
    }