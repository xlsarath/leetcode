import java.util.Arrays;

public class MaxiumProfitInJobScheduling1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit, int workers) {

        int n = profit.length;
        Job[] job = new Job[n];
        int totProfit = 0;
        for(int i = 0; i < n ; i++){
            job[i] = (new Job(startTime[i],endTime[i],profit[i]));
            totProfit += profit[i];
        }

        Arrays.sort(job,(a,b)->a.end - b.end);

        int dp[] = new int[n];
        dp[0] = job[0].profit;

        for(int i = 1; i < n; i++){
            int currProfit = job[i].profit;

            int index = search(job,i);

            if(index != -1) currProfit += dp[index];

            dp[i] = Math.max(currProfit, dp[i-1]);
        }
      return totProfit - dp[n-1];
    /*    int n = profit.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = (new Job(startTime[i], endTime[i], profit[i]));
        }
        
        int dp[] = new int[jobs.length];
        Arrays.sort(jobs, (a,b)->(a.end - b.end));
        
        dp[0] = jobs[0].profit;
        for (int i = 1; i < jobs.length; i++){
            dp[i] = Math.max(jobs[i].profit, dp[i-1]);
            for(int j = i-1; j >= 0; j--){
                if(jobs[j].end <= jobs[i].start){
                    dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
                    break;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int val : dp) {
            max = Math.max(val, max);
        }
        return max; */
    }
    
    private int search(Job[] job, int i) {

        int start = 0;
        int end = i -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(job[mid].end <= job[i].start){
                if(job[mid+1].end <= job[i].start){
                        start = mid +1;
                } else return mid;
            } else end = mid -1;
        }

        return -1;
    }

    class Job {
        int start, end, profit;
        
        public Job(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.profit = p;
        }
    }

    public static void main(String[] args) {
        System.out.println("remaining workers will get : "+new MaxiumProfitInJobScheduling1235().jobScheduling(new int[] {1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60}, 4));
    }
}