//space compleixty : O(mn) m and n are lengths of String s and p.
//space complexity : O(mn)
public class WildcardMatching44 {

        public boolean isMatch(String s, String p) {
            
            int m = s.length();
            int n = p.length();
            
            boolean[][] result = new boolean[m+1][n+1];
            
            result[0][0] = true;
            
            for(int i = 1; i <= m; i++ ){
                result[i][0] = false;
            }
            
            for(int i = 1; i <= n ; i++ ){
                
                if(p.charAt(i-1) == '*'){
                    result[0][i] = true;
                } else {
                    break;
                }
            }
            
            for(int i = 1; i <= m; i++){
                for (int j = 1; j <= n; j++){
                    if(p.charAt(j-1) == '*'){
                        result[i][j] = result[i][j-1] ||  result[i-1][j];
                    } else if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?'){
                        result[i][j] = result[i-1][j-1];
                    }
                }
            }
            return result[m][n];
        }
    }

