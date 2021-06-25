import java.util.List;
//time complexity : O(n)
//space complexity : O(1)
//leet code : yes
//steps : dp
public class Triangle120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int output[] = new int [n];
        
        int i = n-1;

            for(int j = 0; j < n; j++){
                output[j] = triangle.get(i).get(j);
            }
            
            int cols = n-1;
            for(i = n-2; i >= 0; i--){
                for(int j = 0; j < cols; j++){
                    output[j] = Math.min(output[j],output[j+1]) + triangle.get(i).get(j);
                }
                cols--;
            }
            return output[0];
        }
    }
}