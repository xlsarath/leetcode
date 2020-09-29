//akuna
public class NumberOfOne {
	// unsigned int
	public static int countOne(int n){
		int cnt = 0;
		int i = 0;
		while(i < 32){
			cnt += (n>>i) & 1;
			i++;
		}
		return cnt;
	}
	
	public static void main(String[] args){
		for(int i = -15; i < 16; i++){
			assert countOne(-5) == Integer.bitCount(-5);
		}
		System.out.println(countOne(-5));
		System.out.println(Integer.bitCount(-5));
	}
}