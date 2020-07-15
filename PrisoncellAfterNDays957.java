import java.util.Arrays;

//space complexity : O(1)
//time complexity: O(1) <-- coz at the max it takes 14 calls
//https://math.stackexchange.com/questions/3311568/why-does-this-pattern-repeat-after-14-cycles-instead-of-256-can-you-give-a-proo/3311963#3311963
public class PrisoncellAfterNDays957 {

    public int[] prisonAfterNDays(int[] cells, int N) {

        N = N % 14 == 0 ? 14 : N % 14; // cycle repeates same for every 14days
       
        for(int i = 1; i <= N; i++){
                int prev = cells[0];
                cells[0] = 0;
                for(int j = 1; j < 7; j++ ){
                    int temp = cells[j];
                    if(prev == cells[j+1]){
                        cells[j] = 1;
                    } else {cells[j] = 0;}
                    prev =temp;
                }
                cells[7] = 0;
        }
return cells;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrisoncellAfterNDays957().prisonAfterNDays(new int[] {0,1,0,1,1,0,0,1}, 10^8)));
    }
}