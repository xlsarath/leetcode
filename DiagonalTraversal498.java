//TIme complexity : O(m x n)
//space complexity : O(m x n)
//Leet code execution : 
//Steps: for traversal there are three cases while traversing up, row--,col++, if it's fist row then col++ and reverse direction. if it's last column row++ and direction reverse.
//viceversa for travelling down but negation of what we do in UP cases.
class DiagonalTraversal498 {

    public int[] findDiagonalOrder(int[][] matrix) {

        if(matrix==null||matrix.length==0) return new int[0];

        int row=0,col=0,direction=1; //up;-1 down
        int i=0;
        int m = matrix.length,n = matrix[0].length;
        int [] result = new int[m*n];

        while(i<m*n){

            result[i] = matrix[row][col];
            if(direction==1){//up
                if(col==n-1){
                    row++;
                    direction = -1;
                }else if(row==0){
                    col++;
                    direction=-1;
                }
                else {
                    row--;
                    col++;
                }
            }
                else {//down
                    if(row==m-1){
                        col++;
                        direction =1;
                    }else if (col ==0){
                        row++;
                        direction =1;
                    }
                    else {
                        row++;
                        col--;
                    }
                }
                i++;

        }
        return result;

    }



    public static void main(String[] args) {
        DiagonalTraversal498 dt = new DiagonalTraversal498();
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        
        for(int i: dt.findDiagonalOrder(matrix)){
            System.out.println(i);
        }
        
    }
}