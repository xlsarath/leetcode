class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                String  str   = q.poll();
               // System.out.print(str+" ");
                   if(set.contains(str)) continue;
                   else set.add(str);
                   char ch[] = str.toCharArray();
                   for(int k = 0 ; k < ch.length; k++){
                       if(Character.isDigit(ch[k])) continue;
                       char temp = ch[k];
                       ch[k] = Character.toLowerCase(ch[k]) ;
                       q.add(String.valueOf(ch));
                       ch[k] = Character.toUpperCase(ch[k]) ;
                       q.add(String.valueOf(ch));
                       ch[k] = temp;
                   }
                   
               }    
            }
            
            
        
        for(String val : set)
            result.add(val);
       return result; 
    }
}