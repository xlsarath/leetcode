//time complexity : O(n)
//SPace complexity : O(n) ,  here n os the length of array
//leet code execution : successfull
//Steps: take two variables one is to maintain left product and other is for right product. Firstly initialise ur result array with 1 at index 0 and start iterating the given array
//       and multiply every element at[i] with it's [i-1] element and keep running prod in leftprod variable. Similarly reverse iterate result array and multiply every element with rightproduct and assign given array elements to rightproduct before doing product with results.


class ProductOfArrayExecptSelf{

    public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        int leftProd=1,rightProd=1;
        //2,3,4,6
        //0,1,2,3
        result[0]=1;
        for(int i=1;i<nums.length;i++){
            result[i]=leftProd*nums[i-1]; //1*2;2*3;6*4
            leftProd=result[i];//2,6,24
        }
        //1,2,6,24

        for(int i= nums.length-1;i>=0;i--){
            result[i] =result[i] * rightProd; // 24*1;6*6;24*2;72*1
            rightProd = rightProd * nums[i]; //1*6;6*4;24*3*;72*1
        }

        //

        return result;
    }


    public static void main(String[] args) {
        
        ProductOfArrayExecptSelf pa = new ProductOfArrayExecptSelf();
        int res[] = {2,3,4,6};
        for(int i: pa.productExceptSelf(res)){
            System.out.println(i);
        }

    }
}