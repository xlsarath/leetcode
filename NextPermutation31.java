//time complexiy: O(n)
//space complexity : O(1)
//leet code : yes
//steps : check for ascending order from left to right. mark the index of conflict element. again run over from left to right and compare against value at marked index. and swap the elements are loop exhaustion. finally reverse the elements between them.
public class NextPermutation31 {

    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        if(n==1) return;    
        int i = n-2;    
            //2 ,4 , 7 ,6, 5 ,3 ,1
            while( i>=0 && nums[i]>=nums[i+1]){
                i--;
            }
        
            if(i>=0){
                
                int j = n -1;
                while(nums[j]<=nums[i]){
                    j--;
                }
                swap(nums,i,j);
            }
            
            reverse(nums, i+1, n -1); 
            for(int o:nums)System.out.println(o);
        }
        
        
        public void reverse(int nums[], int start, int end){
            
            while(start < end){
                swap(nums, start, end);
                start++;
                end--;
            }
            
        }
        
        
        public void swap(int nums[], int start, int end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
        }


public static void main(String[] args) {
    new NextPermutation31().nextPermutation(new int[]{2 ,4 , 7 ,6, 5 ,3 ,1});
}

}