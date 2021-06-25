import java.util.*;
//space complexity : O(n);
//time complexity : O(n);

public class ZigZagConversion_6 {

        public String convert(String s, int numRows) {
            
            if(numRows == 1) return s;
            
        List<StringBuilder> result = new ArrayList<>();
         
         for(int i = 0 ; i < Math.min(s.length(),numRows); i++)
             result.add(new StringBuilder());
            
        int rowNum  = 0;
        boolean colChange = false;
         for(char c : s.toCharArray()){     
             
             result.get(rowNum).append(c);
             
             if(rowNum == 0 || rowNum == numRows-1)
                 colChange = !colChange;
             
             rowNum += colChange ? 1 : -1;
    
         }   
            
         StringBuilder sb = new StringBuilder();   
         for(StringBuilder row : result)
             sb.append(row);
         
          return sb.toString();  
            
        }
    

}