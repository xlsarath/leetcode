
class MergeSortedArray88{

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        

    //    for(int i=m; i<nums1.length;i++){
    //        nums1[i]=nums2[i-n];
    //    }
    //    Arrays.sort(nums1);   
    //    for (int ii : nums1) {
    //        System.out.println(ii);
    //    }

    int first = m-1,second = n-1;
    while(first>=0 && second >=0){
        if(nums1[first]>nums2[second]){
            nums1[first+second+1] = nums1[first];
            first--;
        }
        else {
            nums1[first+second+1] = nums2[second];
            second --;
        }

    }
    while(second>=0){
        nums1[second]=nums2[second];
        second--;
    }

    for(int i:nums1){
        System.out.println(nums1[i-1]);
    }
    
    }




    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        MergeSortedArray88 msa = new MergeSortedArray88();
        msa.merge(nums1, 3, nums2, 3);
    }
}