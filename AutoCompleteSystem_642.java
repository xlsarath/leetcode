/*
LeetCode. 
https://leetcode.com/problems/design-search-autocomplete-system/description/
Design a search autocomplete system for a search engine. 
Users may input a sentence (at least one word and end with a special character '#'). 
For each character they type except '#', you need to return the top 3 historical hot sentences 
that have prefix the same as the part of sentence already typed. 
Here are the specific rules:
The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). 
If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, then just return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Your job is to implement the following functions:
The constructor function:
- AutocompleteSystem(String[] sentences, int[] times): This is the constructor. 
The input is historical data. Sentences is a string array consists of previously typed sentences. 
Times is the corresponding times a sentence has been typed. Your system should record these historical data.
- Now, the user wants to input a new sentence. The following function will provide the next character the user types:
List<String> input(char c): The input c is the next character typed by the user. 
The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). 
Also, the previously typed sentence should be recorded in your system. 
The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2]) 
The system have already tracked down the following sentences and their corresponding times: 
"i love you" : 5 times 
"island" : 3 times 
"ironman" : 2 times 
"i love leetcode" : 2 times 
Now, the user begins another search: 
Operation: input('i') 
Output: ["i love you", "island","i love leetcode"] 
Explanation: 
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. 
Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman".
Also we only need to output top 3 hot sentences, so "ironman" will be ignored. 
Operation: input(' ') 
Output: ["i love you","i love leetcode"] 
Explanation: 
There are only two sentences that have prefix "i ". 
Operation: input('a') 
Output: [] 
Explanation: 
There are no sentences that have prefix "i a". 
Operation: input('#') 
Output: [] 
Explanation: 
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. 
And the following input will be counted as a new search. 
Note:
The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.
The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in the historical data won't exceed 100.
Please use double-quote instead of single-quote when you write test cases even for a character input.
Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are persisted across multiple test cases. Please see here for more details.
*/

import java.util.*;
public class AutoCompleteSystem_642 {

    TrieNode root;

    AutoCompleteSystem_642(){
            
        root = new TrieNode();

    }

    public void insert(String word){
        TrieNode cursor = root;
        for(int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
                if(cursor.childern[ch-'a'] == null)
                    cursor.childern[ch-'a'] = new TrieNode(); 
             cursor = cursor.childern[ch-'a'];       
        }
        cursor.isWord = true;
        System.out.println(" cursor.isWord "+cursor.isWord);
    }


    public boolean searchPrefix(String word){
        TrieNode cursor = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(cursor.childern[ch-'a'] == null)
                return false;
            cursor  = cursor.childern[ch-'a'];    
        }
        return true;
    }

    public boolean searchWord(String word){
        TrieNode cursor = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(cursor.childern[ch-'a'] == null)
                return false;
            cursor  = cursor.childern[ch-'a'];    
        }
        return cursor.isWord;
    }

    public List<List<Character>> getAllWordsMatchingPrefix(String word){
        TrieNode cursor = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(cursor.childern[ch-'a'] == null)
                return new ArrayList<>();
            cursor  = cursor.childern[ch-'a'];    
        }

        List<List<Character>> result = new ArrayList<>();
        List<Character> state = new ArrayList<>();
        dfs(result, cursor, state);

        return result;
    }



    private void dfs(List<List<Character>> result, TrieNode cursor, List<Character> list) {

        if(cursor.isWord) 
        { 
            System.out.println(" >>  ins"+list);
            result.add(new ArrayList(list));
            return;
        }

        if(cursor == null) {
            System.out.println(" null enc");
            return;
        }

        for(int i = 0 ; i < 26; i++){
           // System.out.println((char) i+" "+i);
            if(cursor.childern[i] != null){
                System.out.println(" i val "+i);
              //  char b = Integer.toString(i).charAt(0);
              //  System.out.println(cursor.childern[i]+" "+(Integer.toString(i).charAt(0))+" "+b);
              //  System.out.println((char)i+" nnn"+ (char)(i-26)+" kkk"+(char)(i+26)+" "+Character.toString ((char) i)+" "+i);
                char b = (char) (i+96);
                list.add(b);
               // System.out.println(sb.toString());
               // TrieNode temp = cursor.childern[i];
              //  System.out.println(list+" <><>"+b+" >> "+i);
               dfs(result, cursor.childern[i] , list);
              list.remove(list.size()-1);

                
            }
        }

    }

    class TrieNode {
        TrieNode[] childern;
        boolean isWord;
        TrieNode(){
            childern = new TrieNode[26];
        }
    }

    public static void main(String[] args){
        
        AutoCompleteSystem_642 a = new AutoCompleteSystem_642();
        a.insert("sam");
        a.insert("sap");
        a.insert("sling");
        System.out.println(a.getAllWordsMatchingPrefix("s"));
        

    }
}
