class Solution {
    public int findTheWinner(int n, int k) {
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1 ; i <= n ; i++) // num starts from 1
            q.add(i);
        
        while(q.size() > 1){
            int temp = k;
            while(temp > 1){
                q.offer(q.poll());
                temp--;
            }
            q.poll();
        }
        return q.poll();
    }
}