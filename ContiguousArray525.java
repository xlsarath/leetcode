import java.util.HashMap;

class ContiguousArray525{

    private int find(int arr[]){

        if(arr.length==0||arr==null)
            return 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int rSum =0,max =0;
        for(int i =0; i<arr.length;i++){
            rSum = arr[i]==0 ? rSum -1 : rSum +1;
            if(!map.containsKey(rSum))
                map.put(rSum, arr[i]);
            else
                max = Math.max(max, i-map.get(rSum));
        }
        return max;
    }


    public static void main(String[] args) {

        ContiguousArray525 ca = new ContiguousArray525();
        int arr[] = {0,1,0,1,1,1,1,1,0,0,1,0,1};
        System.out.println(ca.find(arr));
        

    }
}