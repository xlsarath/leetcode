// time complexity : O(numRows^2)
// space complexity : O(numRows^2)
class Solution {
    
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        res.add(new ArrayList<>());
        res.get(0).add(1);
        
        for(int i = 1 ; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            List<Integer> prevRow = res.get(i-1);
            
            temp.add(1);
            
            for(int j = 1; j < i; j++)
                temp.add(prevRow.get(j-1) + prevRow.get(j));
            
            temp.add(1);
            
            res.add(temp);
        }
        
        return res;
        
    }
}