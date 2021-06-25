class BeautifulArrangement523 {
    int count =0;
    public int countArrangement(int N) {
        if(N==0) return 0;
        backtrack(N,1,new int[N+1]);
        return count;
    }
    
   public void backtrack(int N, int pos, int[] usage){

       if(pos>N){
           count++;
           return;
       }
      
        
       for(int i=1;i<=N;i++){
           if(usage[i]==0 && (i%pos==0||pos%i==0)){
               usage[i]=1;
               backtrack(N,pos+1,usage);
               usage[i]=0;
           }
       }
       
   }

   public static void main(String[] args) {
       BeautifulArrangement523 ba = new BeautifulArrangement523();
       System.out.println(ba.countArrangement(2));
   }
}