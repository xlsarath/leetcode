class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        //int dp[] = new int[365];
        int max = Arrays.stream(days)
                        .max()
                        .getAsInt();
        
        int dp[] = new int[max + 1];
        HashSet<Integer> set = new HashSet<>();
        for(int day : days) set.add(day);
        
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1 ; i < dp.length; i++){
            
            if(set.contains(i)){
                dp[i] = min(
                    dp[i-1] + costs[0],
                    dp[Math.max(i-7,0)] + costs[1],
                    dp[Math.max(i-30,0)] + costs[2]
                );   
            } else {
                dp[i] = dp[i-1];
            }
                                
       }
        
        
return dp[max];        
        
    }
    
    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }
}