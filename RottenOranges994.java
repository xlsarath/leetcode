import java.util.LinkedList;
import java.util.Queue;
//time complexity : O(n)
//space complexity : O(n)
//leet code : yes
// steps : iterate grid and store co-ordinates of rotten orange and intialise BFS and change respective cell 
class RottenOranges994{

    public int orangesRotting(int[][] grid) {

        if(grid==null||grid.length==0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                    queue.add(new Pair(i, j));
                if (grid[i][j] == 1)
                    freshOranges++;
            }
        }

        if(freshOranges==0) return 0;
        int time = 0;
        int dx[] = {-1,0,1,0};
        int dy[] ={0,1,0,-1};
        while(!queue.isEmpty()){
            time++;
            int level = queue.size();
            for(int i=0;i<level;i++){
                Pair cell = queue.poll();

                for(int j=0;j<4;j++){
                    int x = cell.x + dx[j];
                    int y = cell.y+dy[j];
                    if(x>=0 && y>=0 && x<m &&y<n && grid[x][y]==1){
                        grid[x][y]=2;
                        freshOranges--;
                        if(freshOranges==0) return time;
                        queue.add(new Pair(x, y));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RottenOranges994 ro = new RottenOranges994();
        int arr[][] = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(ro.orangesRotting(arr));

    }
    public class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
}
}