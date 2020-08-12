import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PhotoAlbum {




    public static void main(String[] args) {
        int n = 5;
        int index[] = {0, 1, 2, 1 ,2};
        int identity[] = {0,1,2,3,4};

        String example = "sarath chandra,hello geek";
        String str[] = example.split(",");

        System.out.print(str[1].split(" ")[1]+" ");

        char [] reverse = str[0].split(" ")[0].toCharArray();

        for(int i = reverse.length-1; i >= 0 ;i--){
            System.out.print(reverse[i]);
        }

        System.exit(-1);





        int arr1[] = {1,2,3};
        int[] arr1_backup = arr1;
        for(int  i : arr1_backup)
        System.out.println(arr1_backup[i]);

        


        sortAlbum(n,index,identity);
    }

    private static void sortAlbum(int n, int[] index, int[] identity) {

        LinkedList<Integer> sortedList = new LinkedList<>();
        HashMap<Integer,Integer> location = new HashMap<>();

        for(int i = 0 ; i < index.length; i++){
            location.put(i,index[i]);
        }

        for(int i = 0 ; i < identity.length; i++){
            sortedList.add(location.get(i), identity[i]);
        }

        System.out.println(sortedList);

    }

}