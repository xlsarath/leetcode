
public class Insertion_sort_part_01_hackerrank {


    static void insertionSort1(int n, int[] arr){
        int x=arr[n-1], i;
        for(i=n-1;i>0 && arr[i-1]>x;i--){
            arr[i]=arr[i-1];
            for(int j : arr) System.out.print(j+" ");
            System.out.println();
        }
        arr[i]=x;
        for(int j : arr) System.out.print(j+" ");
 
    }

    public static void main(String[] args) {
        Insertion_sort_part_01_hackerrank.insertionSort1(5, new int[]{2,4,6,8,3});
    }

}