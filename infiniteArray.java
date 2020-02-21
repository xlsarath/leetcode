/*
This works for very large sized infinite array ..as it's inevitable to run into array index out of bounds exception
*/
class infiniteArray{
    

    public int search(int arr[], int target){
        int low =0;
        int high =1;

        while(arr[high]<target){
            low = high;
            high = 2 *(high);
        }

        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]<target){
                low = mid +1;
            }
            else {
                high = mid -1;
            }

        }
        return -1;
    }

    
    public static void main(String[] args) {
        
        infiniteArray ia = new infiniteArray();
        int arr[] = {1,2,3,4,6,7,7,8,9,13,11};
        System.out.println(ia.search(arr, 13));
    }
}