/** https://leetcode.com/problems/group-anagrams/ --- leet code 49
 * Time complexity : a) using groupAnagrams function it's O(n(klogk))
 *                   b) using number theory approach (prime numbers) it's O(nk)
 * Space Complexity: O(1)
 * Leet Code execution : successfull
 * Steps:
 *   method a) : 1) from list of strings, consider a string and split it into chars and sort'em and form the String back
 *               2) Now store sorted string into HM key, and add actual word as value (if it's new value create list and add word, else append it to list)
 *               3) run until the length and return list(list)
 *  method b) : 1) same as above, but here we map each char with unique prime number and get a product for each word. So the trick is when there's a product match it's Anagram.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class AnagramsHM{


    private long primeProduct(String s){

        int []prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103};
        int product = 1;

        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            product = product * prime[ch-'a'];
        }

        return product;

    }

 
    public List<List<String>> groupAn(String[] strs){
        if(strs == null) return null;

        HashMap<Long,List<String>> map = new HashMap<>();
        for(String word: strs){
            long primeProduct = primeProduct(word);
            if(!map.containsKey(primeProduct)){
                map.put(primeProduct, new ArrayList<String>() );
            }
            map.get(primeProduct).add(word);
        }

        return new ArrayList<List<String>>(map.values());
    }


    public List<List<String>> groupAnagrams(String[] strs){

        if(strs == null) return null;

        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : strs){

            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String sorted = String.valueOf(chars);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<String>());
            }
            map.get(sorted).add(word);
        }

        return new ArrayList<List<String>>(map.values());


    }





    public static void main(String[] args) {

        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        AnagramsHM hm = new AnagramsHM();
        System.out.println( hm.groupAnagrams(strs));
        System.out.println( hm.groupAn(strs));


        
    }

}

