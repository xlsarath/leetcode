import java.util.*;


public class Longest_COmmon_Prefix_using_trie {


    static class TrieNode{

        TrieNode[] childern =  new TrieNode[26];
        boolean isLeaf;

            public TrieNode(){
                isLeaf = false;
                Arrays.fill(childern,null);
            }
    }
    

    static TrieNode root;
    static int index; 

    static void insert(String key){

            TrieNode crawler = root;

            for(int i = 0 ; i < key.length(); i++){
                int loc = key.charAt(i) - 'a';
                if(crawler.childern[loc] == null) crawler.childern[loc] = new TrieNode();
                
                crawler = crawler.childern[loc];
            }

            crawler.isLeaf = true;
    }


    static int countChildern(TrieNode node){

        int count = 0;

        for(int i = 0 ; i < 26; i++){

            if(node.childern[i] != null) {count++;
            index = i;}
        }
        return count;
    }

    static String walkTrie(){
        TrieNode crawl = root;
        index = 0;
        String prefix = "";

        while(countChildern(crawl) == 1 && crawl.isLeaf == false){
            crawl = crawl.childern[index];
            prefix += (char) ('a' + index);
        }
        return prefix;
    }

    static void constructTrie(String arr[], int n ){

            for(int i  = 0 ; i < n; i++)
            insert(arr[i]);

        return;
    }

    static String commonPrefix(String arr[], int n){

        root = new TrieNode();
        constructTrie(arr, n);

       return walkTrie(); 
    }


    public static void main(String[] args) {

        String arr[] = {"geeksforgeeks", "geeks", 
                        "geek", "geezer"}; 
        int n = arr.length; 
       
        String ans = commonPrefix(arr, n); 
       
        if (ans.length() != 0) 
            System.out.println("The longest common prefix is "+ans); 
        else
            System.out.println("There is no common prefix"); 



    }

}