import java.util.PriorityQueue;

class KthSmallestElementinaSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
    

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            
        for(int i =0 ; i<matrix[0].length; i++){
            System.out.println(matrix[i][0]);
                 minHeap.add(matrix[i][0]);
        } 

        for(int i =0 ; i < minHeap.size(); i++) {
          //  System.out.println(minHeap.peek());
        }

        int count = 0,val = minHeap.poll();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(minHeap.peek()<matrix[i][j]){
                    k++;
                }
                else if(minHeap.peek()>=matrix[i][j]){
                    minHeap.poll();k++;
                }
            }
        }

        return minHeap.peek();

    }

public static void main(String[] args) {

    KthSmallestElementinaSortedMatrix km = new KthSmallestElementinaSortedMatrix();
    System.out.println(km.kthSmallest(new int[][] {{1,5,9},{10,11,13},{12,13,15}}, 8));
    
}


}


1   5   9
10  11  13
12  13 15

1 5 9 10 11 12 13 13 15