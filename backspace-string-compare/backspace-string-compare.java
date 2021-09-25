class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        //Input: s = "ab##", t = "c#d#"

        int i = s.length() -1;
        int j = t.length() - 1;
        int  sCount = 0, tCount = 0;

        while(i >= 0 || j >= 0){
               
            if(i >= 0 && s.charAt(i) == '#') { 
                        sCount++; 
                        i--; 
                        continue;
                } else if (i >= 0 && s.charAt(i) != '#' && sCount > 0) {
                    sCount--;
                    i--;
                continue;
                }                 
                                            
             
            if(j >= 0 && t.charAt(j) == '#') {
                j--;
                tCount++;
                continue;
            } else if (j >= 0 && t.charAt(j) != '#' && tCount > 0){
                tCount--;
                j--;
                continue;
            }
        
                    
            if(i <  0 && j < 0) return true;
            if(i < 0 || j < 0) return false;
            if(i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
            
            i--;
            j--;
            
        }
        
        return true;
        
        
    }
}

//"bxo#j##tw"
