// time complexity : O(n) n is the max length of T
//space complexity : O(1)
//leet code : yes
//steps : used frequncy of chars in strings.
class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        int[] frequency = new int[26];
        
        
        //populate
        
        for(char ch:T.toCharArray()){
            int index = ch -'a';
            frequency[index]++;
        }
        
        //custom order
        for(char ch : S.toCharArray()){
            int index = ch-'a';
            int count = frequency[index];
            writeChar(sb, ch, count);
            frequency[index]=0;
        }
        
        //left out
        for(int i=0;i<26;i++){
            char ch = (char)('a' + i);
            writeChar(sb, ch, frequency[i]);
            frequency[i] = 0;
        }
        
        return sb.toString();
    }
    
    
    public void writeChar(StringBuilder sb, char ch, int count){
        while(count>0){
            sb.append(ch);
            count--;
        }
    }
}