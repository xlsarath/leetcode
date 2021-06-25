
public class IslandPerimeter463 {

    public int islandPerimeter(int[][] grid) {
        
        if(grid==null || grid.length == 0) return 0;
     
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                
                if(grid[i][j] == 1){
                    perimeter += 4;
                 if(i > 0 && grid[i-1][j] == 1)
                     perimeter -= 2;
                if(j > 0 && grid[i][j-1] == 1)
                    perimeter -= 2;

                }
                
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        System.out.println(new IslandPerimeter463().islandPerimeter(new int[][] {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }

}

