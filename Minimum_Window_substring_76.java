
public class Minimum_Window_substring_76 {

        public String minWindow(String s, String t) {
            if(s.isEmpty()) return "";
            int[] need = new int[128];
            for(char c : t.toCharArray()) need[c]++;
            char[] a = s.toCharArray();
            int r = 0, l = 0, missing = t.length(), i = 0, j = 0;
            while(r < s.length()){
                if(need[a[r]] > 0) missing --;
                need[a[r]]--;
                r ++;
                while(missing == 0){
                    if(j == 0 || (r - l) < (j - i)){
                        j = r;
                        i = l;
                    }
                    need[a[l]]++;
                    if(need[a[l]] > 0) missing++;
                    l++;
                }
            }
            return s.substring(i, j);
        }
    }