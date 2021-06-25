
public class Remove_Adjacent_char_duplicates_in_a_String {

    
        // Function to remove adjacent duplicates characters from a string
        public static String removeDuplicates(char[] chars)
        {
            char prev = '\0';
            int k = 0;
    
            for (char c: chars) {
                if (prev != c) {
                    chars[k++] = c;
                    prev = c;
                }
            }
    
            return new String(chars).substring(0, k);
        }
    
        public static void main(String[] args)
        {
            String s = "AAABBCDDD";
    
            s = removeDuplicates(s.toCharArray());
            System.out.println(s);
        }
    }