import java.util.LinkedList;
import java.util.Queue;
//time complexity :  O(m x n)
//space complexity : O(m x n)
//leetcode : yes
// steps : method BFS, while fetching neighbours ensure cell get's coloring is the cell that's need to be colored. to avoid recalls enusre no neighbours is called more than once. 
class FloodFill733 {

   public class Pair{
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int[][] floodFill_DFS(int[][] image, int sr,int sc,int newColor){

        if(image.length==0||image==null) return null;
        
    
        if(newColor==image[sr][sc]) return image;

        dfsVisit(image, image[sr][sc], sr,sc, newColor);

        return image;

    }

    private void dfsVisit(int[][] image, int srcColor, int sr, int sc, int newColor) {
        image[sr][sc] = newColor;

        for(int i=0;i<4;i++){
            int x = sr + dx[i];
            int y = sc + dy[i];
            if(isValid(image,x,y) && image[x][y]==srcColor){
                dfsVisit(image, srcColor, x, y, newColor);
            }
        }
    }

    private boolean isValid(int[][] image, int x, int y) {
        return (x>=0 && y>=0 && x<image.length && y<image[0].length);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

    // edge cases condition
        if(image.length==0||image==null) return null;
    // add pair to queue 
    int m= image.length;
    int n = image[0].length;
    int dx[] = {-1,0,1,0};
    int dy[] ={0,1,0,-1};
    int color =  image[sr][sc];
    image[sr][sc] = newColor;
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(sr,sc));
    //BFS
    while(!queue.isEmpty()){
        int level = queue.size();
        for(int i=0;i<level;i++){
            Pair cell = queue.poll();
            for(int j=0;j<4;j++){
                int x = cell.x + dx[j];
                int y = cell.y + dy[j];

                if(x >=0 && y>= 0 && x <m && y <n && image[sr][sc] == color ){
                    if(image[x][y]!=newColor){
                        image[x][y]=newColor;
                        queue.add(new Pair(x, y));
                    }

                }
            }


        }
    }
    return image;
    
    }




}