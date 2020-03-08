import java.util.LinkedList;
import java.util.Queue;
//time complexity : O(mxn)
//space complexity : O(mxn)
//leet code : yes
//steps :  create a new array and populate entirely with max integer value. now follow BFS and update the new array filled with max values upon comparison with value at x and y cordinates if value is lesser than adjacent cells.  
class Matrix_01_542 {
    
    int dx[] ={-1,0,1,0};
    int dy[] = {0,1,0,-1};
    public int[][] updateMatrix(int[][] matrix) {
    int m = matrix.length;
    if(m==0) return matrix;
    int n = matrix[0].length;

    int[][] result = new int[m][n];
    Queue<Pair> queue = new LinkedList<>();
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            result[i][j] = Integer.MAX_VALUE;
            if(matrix[i][j]==0){
                result[i][j]=0;
                queue.add(new Pair(i, j));
            }
        }
    }

    while(!queue.isEmpty()){
        Pair current = queue.poll();
        for(int i=0;i<4;i++){
            int x = current.x + dx[i];
            int y = current.y + dy[i];
            if(isValid(m,n,x,y)){
                if(result[current.x][current.y]+1 < result[x][y]){
                    result[x][y] = result[current.x][current.y]+1;
                    queue.add(new Pair(x,y));
                }
            }
        }
    }
    return result;
    
    }

    private boolean isValid(int m, int n, int x, int y) {
        return x>=0 && y>=n && x<m && y<n;
    }


}

class Pair{

    int x,y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}