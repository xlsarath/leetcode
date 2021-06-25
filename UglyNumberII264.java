import java.util.ArrayList;
import java.util.List;
//time complexity : O(n)
//space complexity : O(1)

class UglyNumberII264 {
    public int nthUglyNumber(int n) {
        
        if(n <= 6 ) return n;

        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);

        int i2 = 0, i3 =0, i5 =0;
        while(ugly.size() < n){
            int next = (int) Math.min(ugly.get(i2) * 2L, (Math.min(ugly.get(i3) * 3L, ugly.get(i5) * 5L)));

            if( next == ugly.get(i2)* 2L)
                i2++;
            if(next == ugly.get(i3) * 3L)
                i3++;
            if(next == ugly.get(i5) * 5L)
                i5++;
            
                ugly.add(next);
        }
        return ugly.get(n-1);
    }

    public static void main(String[] args) {
        System.out.println( new UglyNumberII264().nthUglyNumber(10));
    }
}   