import java.util.Arrays;

public class Pentagonal {
	public static int[] findPen(){
		int[] res =  new int[2];
		long[] pens = new long[10000];
		for(long i = 0; i < pens.length; i++){
			pens[(int)i] = (i * (3*i - 1) / 2);
		}
		for(int j = 1;j < 10000; j++){
			for(int k = 1; k < j; k++){
				if(isPentagonal(pens, pens[j] + pens[k])
						&& isPentagonal(pens,pens[j] - pens[k])){
					res[0] = (int)pens[k];
					res[1] = (int)pens[j];
				}
			}
		}
		return res;
	}
	
	private static boolean isPentagonal(long[] pens, long num){
		if(Arrays.binarySearch(pens, num) >= 0){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] res = findPen();
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}
	}
	
}