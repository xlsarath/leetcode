//time complexity : o(n)
//space complexity : O(1)
//leet code execution : yes
//steps : DP 

public class AirthmeticSlices413 {

        public int numberOfArithmeticSlices(int[] A) {
        if(A ==null || A.length == 0) return 0;
    
            //bruteforce
          /**  
            
            int count = 0;
            for(int i = 0;i < A.length-2; i++){
                int diff = A[i+1] - A[i];
                for(int j = i+2; j < A.length; j++ ){
                    if(A[j] - A[j-1] == diff) count ++;
                    else break;
                }
            }
            return count;
            */
            
            //linear
            int count = 0;
           // int result[] = new int [A.length];
            int current = 0, right = 0;
            for(int i = A.length-3; i >= 0; i--){
                
                if(A[i+1]-A[i] == A[i+2] -A[i+1]) {
                 //   result[i] = 1 + result[i+1];
                  current = 1 + right;
                    count += current;
                    right = current;
                } else {
                    right = 0;
                }
            }
                return count;
            
        }
    }