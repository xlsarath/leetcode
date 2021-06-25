class BinarySearchRecurssion{

public int search (int arr[], int target){
    if(arr.length==0 || arr==null){
        return -1;
    }
    return helper(arr,0,arr.length-1,target);
}

public int helper(int[] arr,int  low,int  high, int target){
//base condition
if(high < low){
    return -1;
}
int mid = low + (high-low)/2;
if(arr[mid]==target){return mid;}

if(arr[low]<=arr[mid]){
    //left sorted ??
    if(arr[low]<=target && target <=arr[mid]){
        high = mid -1;
    }
    else {
         low = mid + 1;
        }
}
else {
    if(arr[mid] <= target && target <=arr[high]){
        low = mid +1;
    }
    else {
        high = mid -1;
    }
}
return helper(arr, low, high, target);
}

    public static void main(String args[]){

        BinarySearchRecurssion bn = new BinarySearchRecurssion();
        int sums[] = {4,5,6,7,8,9,10,1,2,3};
        System.out.println(bn.search(sums, 1));

    }
}