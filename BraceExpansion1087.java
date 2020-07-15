//time complexity : O(k^n/k)
//space complexity : O(n/k)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BraceExpansion1087 {


    public String[] expand(String S) {
        // {a,b}cd{e,f}
        List<List<Character>> blocks = new ArrayList<>();
        int index =0;
       while(index < S.length()){
        List<Character> temp = new ArrayList<>();
            if(S.charAt(index) == '{'){
                index++;
                
                    while(S.charAt(index) != '}'){
                        if(S.charAt(index) != ',') { 
                            temp.add(S.charAt(index));
                        }
                        index++;
                    }
            } else {
                temp.add(S.charAt(index));
            }
            index++;
            blocks.add(temp);
            }
            List<String> result = new ArrayList<>();
            backTrack(blocks, 0, new StringBuilder(), result);
            Collections.sort(result);

            String sol[] = new String[result.size()];
            for(int i =  0; i < result.size(); i++){
                sol[i] = result.get(i);
            }
            return sol;

       }

	private void backTrack(List<List<Character>> blocks, int index, StringBuilder sb, List<String> result) {

        if(index == blocks.size()){
            result.add(sb.toString());
            return;
        }

        for(Character ch :  blocks.get(index)) {

            sb.append(ch);
            backTrack(blocks, index+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
       
	}

public static void main(String[] args) {
    for(String s : new BraceExpansion1087().expand("{a,b}c{d,e}f")){
        System.out.println(s);
    }
}

    }   

