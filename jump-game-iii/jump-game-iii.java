class Solution {
    public boolean canReach(int[] arr, int start) {
        
        int zeroIdx = -1;
        for(int i = 0 ; i < arr.length; i++)
            if(arr[i] == 0){
                zeroIdx = i;
                break;
            }
        
        if(zeroIdx==start) return true;
        if(zeroIdx == -1) return false;
        boolean vis[] = new boolean[arr.length];
        return dfs(arr, start, vis);        
    }
    
    
    
    public boolean dfs(int[] arr, int start, boolean vis[]){
        
        //return
        if(start < 0 || start >= arr.length || vis[start]) return false;
        
        if(arr[start] == 0) return true;
        
        vis[start] = true;
        if(dfs(arr, arr[start]+start, vis)) 
            return true;
     
        if(dfs(arr, start-arr[start], vis)) 
            return true;
        
        return false;
    }
}