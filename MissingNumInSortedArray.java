class MissingNumInSortedArray {

    private int missingNum(int arr[]){
        if(arr.length==0||arr==null){return -1;}

        int low =0;
        int high = arr.length-1;
        int mid =0;
        while(high-low>=2){
            mid  = low + (high-low)/2;
            int midIdxdiff = arr[mid] - mid; 
            int lowIdxDiff = arr[low]-low; 
            if(midIdxdiff!=lowIdxDiff){
                high = mid;
            } else {
                low = mid;
            }

        }

        return (arr[low]+arr[high])/2;
        


    }



    public static void main(String[] args) {

        MissingNumInSortedArray min = new MissingNumInSortedArray();
        int arr[] = {3,4,5,6,7,9};
        System.out.println(min.missingNum(arr));
        
    }
}