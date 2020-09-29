import java.util.Arrays;
//akuna
public class CommanCharacter {
	public static String commonCharacter(String s1, String s2){
		char[] allChar = new char[256];
		for(int i = 0; i < s1.length(); i++){
			char letter = s1.charAt(i);
			allChar[(int)letter]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s2.length(); i++){
			char letter = s2.charAt(i);
			if(allChar[(int)letter] > 0){
				sb.append(letter);
				allChar[(int)letter]--;
			}
		}
		char[] ar = sb.toString().toCharArray();
		Arrays.sort(ar);
		return new String(ar);
	}
	
	public static void main(String[] args){
		System.out.println(commonCharacter("aabccc", "abcc"));
	}
	
	
}