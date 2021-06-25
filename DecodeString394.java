class DecodeString394{

    private int cursor = 0;
    public String decodeString(String s) {

        StringBuilder result = new StringBuilder();
        int k = 0;
        while(cursor<s.length()){
            //digit
            char token  = s.charAt(cursor);

            if(token>= '0' && token <='9'){
                k = k * 10 + (token-'0');  cursor++;
            }

            else if(token=='['){
                cursor++;
                String nextResult = decodeString(s);
                while(k>0){
                    result.append(nextResult);
                    k--;
                }
            }
            else if(token==']'){
                cursor++;
                return result.toString();
            }
            else {
                cursor++;
                result.append(token);
            }

        }
        return result.toString();
    }
        


    public static void main(String[] args) {
        DecodeString394 dm = new DecodeString394();
        System.out.println(dm.decodeString("2[a2[bc]]xyz"));
        
    }

}