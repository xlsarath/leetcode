
public class ArrangeCoins {

    public int arrangeCoins(int n) {

        int k = 0, levelCount = 0;


       for (int i = 0 ; i < n ; i++){

                    k = 0;
                
                while( k <=levelCount && levelCount <=n){
                    k++;
                    i++;
                }

                levelCount ++;

       }

return k;
    }

    public int arrangeCoins_binary(int n){

        long left = 0, right = n;
    long k, curr;
    while (left <= right) {
      k = left + (right - left) / 2;
      curr = k * (k + 1) / 2;

      if (curr == n) return (int)k;

      if (n < curr) {
        right = k - 1;
      } else {
        left = k + 1;
      }
    }
    return (int)right;
    }


  
        public int arrangeCoins_math(int n) {
          return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
        }
      

public static void main(String[] args) {
    System.out.println(new ArrangeCoins().arrangeCoins(1681692777));
    System.out.println(new ArrangeCoins().arrangeCoins_binary(1681692777));
    System.out.println(new ArrangeCoins().arrangeCoins_math(1681692777));


}


}