//time complexity : O(m+n)
//space complexity : O(1)
//leet code : yes
//steps : use KMP algorithm
class ImplementstrStr28{

    public int strStr(String haystack, String needle) {
    
    int m = needle.length(), n = haystack.length();
    int pi[] = computePi(needle);

    int i = 0, j =0;
    while(i<n){
        if(haystack.charAt(i)==needle.charAt(j)){
            i++;
            j++;
        if(j==m){
            return i-j;
        }
        } else {
            if(j==0){
                i++;
            } else {
                j = pi[j-1];
            }
        }
    }
    return -1;
    
    }

    private int[] computePi(String needle) {

        int n = needle.length();
        int pi[] = new int[n];

        int i=1,j=0;
        while(i<n){
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
                pi[i] = j;
                i++;
            } else {
                if(i==0) {
                    pi[i]=0;
                    i++; 
                } else {
                    j = pi[j-1];
                }
            }
        }

        return pi;

    }

public static void main(String[] args) {
    System.out.println(new ImplementstrStr28().strStr("hello", "ll"));
}



}