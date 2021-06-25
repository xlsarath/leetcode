import java.util.HashMap;
import java.util.Map;

public class ScratchPad {
    private Map<String,Integer> map;
  
    public ScratchPad() {
      map = new HashMap<>();
      map.put("foo", 1);
      map.put("bar", 3);
    }
  
    public int getValue(String input, int numRetries) throws Exception {
      try {
        return map.get(input);
      }
      catch (Exception e) {
        if (numRetries > 3) {
          throw e;
        }
        return getValue(input, numRetries + 1);
      }
    }
public static void main(String[] args) throws Exception {
    System.out.println(new ScratchPad().getValue("fubar", 1));
}  

}
  