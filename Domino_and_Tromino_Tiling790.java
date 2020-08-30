public class  Domino_and_Tromino_Tiling790 {

    public static int numTilings(int N) {
        if(N == 1) return 1;
          else if(N == 2 ) return 2;
          int mod = 1000000007;
          int[] f = new int[N + 1];
          
          f[1] = 1;
          f[2] = 2;
          f[3] = 5;
          for(int i = 4; i <= N; i++) {
              f[i] = 2 * f[i - 1] % mod + f[i - 3] % mod;
              f[i] %= mod;
          }
          return (int) f[N];
      }

     


      public static void main(String args[]){
        System.out.println(numTilings(11));

      }

}