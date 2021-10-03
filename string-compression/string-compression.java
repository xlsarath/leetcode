class Solution {
    public int compress(char[] chars) {
        
        if(chars.length<=1) return chars.length;
          int index = 0;      
          int count = 1;
          for(int i = 0 ; i <= chars.length-1  ; i++){
            if(i!=(chars.length-1) && chars[i] == chars[i+1]){
                count++;
            } else {
                chars[index++] = chars[i]; 
                if(count > 1) {
                    String val = String.valueOf(count);
                    for(int k = 0 ; k < val.length(); k++)
                     chars[index++] = val.charAt(k);  
                    
                }
                count  = 1;
            }
        }
       
        return index ;
    }
}