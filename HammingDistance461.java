class HammingDistance461 {

    public int hammingDistance(int x, int y) {

        int xor = x ^ y;
        int dist =0,z =0;

        while(xor > 0) {

            if((z = xor & 1) == 1){
                    dist++;
            }
            xor >>>= 1;
        }
        return dist;
       // return Integer.bitCount(x^y);
    }



public static void main(String[] args) {
    System.out.println(new HammingDistance461().hammingDistance(1, 4));
}

}