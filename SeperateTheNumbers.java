

    import java.io.*;
    import java.math.*;
    import java.security.*;
    import java.text.*;
    import java.util.*;
    import java.util.concurrent.*;
    import java.util.regex.*;
    /**
     * Sample Input 0

7
1234
91011
99100
101103
010203
13
1
Sample Output 0

YES 1
YES 9
YES 99
NO
NO
NO
NO

     */
    public class SeperateTheNumbers {
 
        // Complete the separateNumbers function below.
        static void separateNumbers(String str) {
      int n = str.length();
                int flag = 0;
                String x = "";
                String temp = "";
                for(int i=1;i<=n/2;i++)
                {
                    x = str.substring(0,i);
                    Long v = Long.parseLong(x);
                    while(x.length()<n)
                    {
                        x+= Long.toString(++v);
                    }
                    if(x.equals(str))
                    {
                        temp = str.substring(0,i);
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1)
                    System.out.println("YES "+temp);
                else
                    System.out.println("NO");
    
        }
    
        private static final Scanner scanner = new Scanner(System.in);
    
        public static void main(String[] args) {
            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
            for (int qItr = 0; qItr < q; qItr++) {
                String s = scanner.nextLine();
    
                separateNumbers(s);
            }
    
            scanner.close();
        }
    }
    
    