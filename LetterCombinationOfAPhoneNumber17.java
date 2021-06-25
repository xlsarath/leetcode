import java.util.*;

public class LetterCombinationOfAPhoneNumber17 {

        private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        
            public List<String> letterCombinations(String digits) {
                
                List<String> ret = new LinkedList<String>();
                if(digits.length() == 0 || digits == null) return ret;
                combination("", digits, 0, ret);
                return ret;
            }
        
            private void combination(String prefix, String digits, int offset, List<String> ret) {
                if (offset >= digits.length()) {
                    ret.add(prefix);
                    return;
                }
                String letters = KEYS[(digits.charAt(offset) - '0')];
                for (int i = 0; i < letters.length(); i++) {
                    combination(prefix + letters.charAt(i), digits, offset + 1, ret);
                }
            }
    }