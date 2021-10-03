class HitCounter {
    
    Deque<Pair<Integer,Integer>> q;
    int total;
    
    public HitCounter() {
        q = new LinkedList<Pair<Integer,Integer>>();
        total = 0;
    }
    
    public void hit(int timestamp) {
        if(q.isEmpty() || q.getLast().getKey() != timestamp)
            q.add(new Pair<Integer,Integer>(timestamp, 1));
        else
        {
            int prev = q.getLast().getValue();
            q.removeLast();
            q.add(new Pair<Integer,Integer>(timestamp, prev+1));
        }
        total++;
    }
    
    public int getHits(int timestamp) {
        
        while(!q.isEmpty() && timestamp - q.getFirst().getKey() >= 300){
            total -=  q.removeFirst().getValue();
        } 
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */