//time complexity : O(m * n)
//space complexity : O(1)
public class ShortestWayToFormString1055 {

    public int shortestWay( String source, String target){

        int sCursor = 0,tCursor = 0,count = 0;

        while(tCursor < target.length()) {
            int currPosition = tCursor;
            while(sCursor < source.length() && tCursor < target.length()){

                if(source.charAt(sCursor) == target.charAt(tCursor)){
                    sCursor++;
                    tCursor++;
                } else {

                    sCursor++;
                }
            }

            if(tCursor == currPosition) return -1;

            sCursor = 0;
            count++;
        }

    return count;

    }

    public static void main(String[] args) {
        System.out.println( new ShortestWayToFormString1055().shortestWay("xyz", "xygxy"));
    }

}