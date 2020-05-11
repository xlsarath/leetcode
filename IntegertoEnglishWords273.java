//time complexity : O(n)
//space complexity : O(1)
//leet code : yes
//steps : implemented using recurssions
class IntegertoEnglishWords273{
        String [] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
           
               String [] tens = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"} ; 
           
           String [] thousands= {"","Thousand","Million","Billion"};
       public String numberToWords(int num) {
               
               if(num==0) return "Zero";
               
               String word = "";
   
               if(num/1000000000 > 0){
                   word = helper(num/1000000000).trim()+" "+"Billion";
               }
               
               num = num % 1000000000;
               if(num/1000000 > 0){
                   word = word+" "+helper(num/1000000).trim()+" "+"Million";
               }
               num = num%1000000;
              if(num/1000 > 0){
                   word = word+" "+helper(num/1000).trim()+" "+"Thousand";
              }
           
               num = num%1000;
               
               word = word +" "+(helper(num)).trim();
               
               return word.trim();
           }
       
       
       
       public String helper(int num){
           
           if(num==0) return "";
           if(num<20) return below20[num]; // 15
           if(num<100) return tens[num/10]+" "+below20[num%10];//99
           
           return (below20[num/100] +" "+"Hundred"+" "+helper(num%100)).trim(); //667
       }
       
       public static void main(String[] args) {
           System.out.println(new IntegertoEnglishWords273().numberToWords(1234567891));
       }
   
}