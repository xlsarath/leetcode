import java.util.*;
public class Matrix_Rotation_hacker_rank {

    static void matrixRotation(List<List<Integer>> matrix, int r) {
        
        
        int[][] arr=new int[matrix.size()][matrix.get(0).size()];
            for(int i=0;i<matrix.size();i++){
                for(int j=0;j<matrix.get(0).size();j++){
                    arr[i][j]=matrix.get(i).get(j);
                }
            }
            int rows=arr.length;
            int cols=arr[0].length;
            int layers=(int)Math.min(rows,cols)/2;
            int x=0;
            int s=r;
            int y=cols-1;
            int z=rows-1;
        for(int q=0;q<layers;q++){
            int v=(rows+cols-2)*2-8*q;
            int rot=s%v;
            while(rot>0){
                rot--;
                int p=arr[x][x];
      
                for(int j=x;j<y;j++){
                    arr[x][j]=arr[x][j+1];             
                }
                for(int i=x;i<z;i++){
                    arr[i][y]=arr[i+1][y];
                }
                for(int j=y;j>x;j--){
                    arr[z][j]=arr[z][j-1];
                }
                for(int i=z;i>x+1;i--){
                    arr[i][x]=arr[i-1][x];
                }
                arr[x+1][x]=p;
        }
        x++;y--;z--;
        s=r;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        }
    }