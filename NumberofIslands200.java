class NumberofIslands200{
//time complexity : O(mxn)
//space complexity : O(mxn)
//leet code : yes
//steps : Use DFS, ensure to modify the cell to diff char to avoid infinite loop.

    public int numIslands(char[][] grid) {
    
        if(grid==null||grid.length==0) return 0;
    
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfsVisit(grid,m,n,i,j);
                }
            }
        }
        return count;
    }

    int dx[] = {-1,0,1,0};
    int dy[] = {0,1,0,-1};

    private void dfsVisit(char[][] grid, int m, int n, int row, int col) {
    grid[row][col]='2';
    for(int i=0;i<4;i++){
        int x = row+dx[i];
        int y = col+dy[i];
        if(x>=0 && y>=0 && x<m && y<n && grid[x][y]=='1'){
            grid[x][y]='2';
            dfsVisit(grid, m, n, x, y);
        }
    }


    }

    public static void main(String[] args) {
        NumberofIslands200 ni = new NumberofIslands200();
        char arr[][] = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}        ;
        System.out.println(ni.numIslands(arr));
    }
}