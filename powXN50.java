//time complexity : n/2
//space complexity : O(1);
//leet code : yes
//steps : divide the power factor by 2 and calculate recursively.
class powXN50{
        public double myPow(double x, int n) {
            long N = n;
            if(n<0){
                if(x==0) return Double.MAX_VALUE;
                x = 1/x;
                N = -1 *N;
            }
            return power(x,N);
        }
        
        
        public double power(double x, long n){
            if(n==0) return 1;
            if(n==1) return x;
            
            double value = power(x,n/2);
            if(n%2==0){
                return value*value;
            } else {
                return x*value*value;
            }
        }
        
    

public static void main(String[] args) {
    
    powXN50 pw = new powXN50();
    System.out.println(pw.myPow(2.0, 8));
}


}