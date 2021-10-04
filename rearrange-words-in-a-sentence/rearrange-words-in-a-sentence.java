class Solution {
    public String arrangeWords(String text) {
        
        if(text == null || text.length() == 0) return text;
        
        String arr[] = text.split(" ");
        
        Arrays.sort(arr, (a,b) -> (a.length() - b.length()));
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < arr.length; i++){
            if(i == 0){
                sb.append(arr[i].substring(0,1).toUpperCase()+arr[i].substring(1).toLowerCase());
            }
            else{
                sb.append(" ");
                sb.append(arr[i].toLowerCase());
            }
        }
        return sb.toString();
    }
}