import java.util.Arrays;
//time complexity :O(2n)
//space complexity : O(n)
//leet code : yes
//steps : greedy approach
class Candy135 {

    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;
            //1,0,2
        int candies[] = new int[ratings.length];
        
        Arrays.fill(candies, 1);
        //left to right;

        for(int i=1; i<ratings.length; i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }

        //left to right
        for(int i=ratings.length-2; i>=0 ; i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }

        int total = 0;
        for(int i:candies)
            total += i;

            return total;

    }

public static void main(String[] args) {
    
    System.out.println(new Candy135().candy(new int[]{1,0,2}));
}

}