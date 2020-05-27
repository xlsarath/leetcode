import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight406 {

        public int[][] reconstructQueue(int[][] people) {
            
            if(people == null || people.length==0) return new int[0][0];
            
            Comparator<int[]> customComparator = new Comparator<>(){
                @Override
                public int compare(int[] a, int[] b){
                    if(a[0]==b[0]){
                        return a[1]-b[1];
                    } else {
                        return b[0]-a[0];
                    }
                }
            };
            //[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
            
            Arrays.sort(people, customComparator);

            //70,71,61,50,52,44
            
            List<int[]> result = new LinkedList<>();

            for(int[] person : people){
                result.add(person[1],person);
            }

            
            return result.toArray(new int[0][2]);
        }


        public static void main(String[] args) {
            int result[][] = new QueueReconstructionByHeight406().reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
            System.out.println();
            for(int i=0; i< result.length; i++){
                for(int j=0; j<result[0].length; j++){
                    System.out.print(result[i][j]);
                }
            }

        }
    }