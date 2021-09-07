class Solution {
    public boolean isStrobogrammatic(String num) {
         if(num == null || num.length() == 0 ) return false;
            
            int low = 0;
            int high = num.length() - 1;

            while(low <= high){

                if(num.charAt(low) == num.charAt(high)){
                    if(num.charAt(low) != '1' && num.charAt(low) != '0' && num.charAt(low)  != '8')
                        return false;
                } else {
                    if((num.charAt(low) != '6' || num.charAt(high) != '9') && (num.charAt(low) != '9' || num.charAt(high) != '6'))
                        return false;
                }
                low++; high--;
            }
        return true;
    }
}