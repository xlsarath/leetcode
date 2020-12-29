public class Find_Numbers_with_Even_Number_of_Digits_1295 {

    
    public static int findNumbers(int[] nums) {
        int count = 0;
                for(int n:nums){
                    if(n>=10 && n<100 || n>=1000 && n<=9999 || n==100000)
                        count++;
                }
                return count;
        
            }

     public static void main(String[] args) {
         
        System.out.println(findNumbers(new int[]{12,345,2,6,7896}));

     }       

}
