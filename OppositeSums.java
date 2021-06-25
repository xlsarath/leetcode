import java.util.HashMap;
import java.util.Map;

public class OppositeSums {
    private int rev(int x)
    {
        int sum = 0;
        while (x > 0)
        {
            sum *= 10;
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
    //arr[i] - rev(arr[i]) =  arr[j] - rev(arr[j]) 
    public int oppositeSum(int[] array)
    {
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < array.length; i++)
        {
            int k = array[i] - rev(array[i]);
            count.put(k, count.getOrDefault(k, 0) + 1);
            if (count.containsKey(k))
            {
                res += count.get(k);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new OppositeSums().oppositeSum(new int[]{1, 20, 2, 11}));
    }
    

}


