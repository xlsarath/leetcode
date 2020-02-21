import java.util.HashSet;

class LongestPalindrome {

    public int palindrome(String s){
        if(s==null||s.length()==0) 
            return 0;
        
        HashSet<Character> set = new HashSet<>();
        int count=0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c))
                {count += 2;
                set.remove(c);}
            else 
                set.add(c);
        }
        if(!set.isEmpty()) count++;
        return count;
    }

    public static void main(String[] args) {
        LongestPalindrome lp =new LongestPalindrome();
        int i = lp.palindrome("dddddfffgghhalk");
        System.out.println(i);
    }
}