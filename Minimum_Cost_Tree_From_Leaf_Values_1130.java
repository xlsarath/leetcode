public class Minimum_Cost_Tree_From_Leaf_Values_1130 {

     private class Node {
        public int minSum;
        public int maxLeaf;

        public Node(int maxLeaf, int minSum) {
            this.maxLeaf = maxLeaf;
            this.minSum = minSum;
        }
    }


    public int mctFromLeafValues(int[] arr) {
          Node result = mctFromLeafValues(0, arr.length - 1, arr, new Node[arr.length][arr.length]);
        return result.minSum;
    }
    
    private Node mctFromLeafValues(int left, int right, int[] arr, Node[][] memo) {
           //    System.out.println(left+" "+right+" ");


        if (left == right) {
           // System.out.println(" >>"+arr[left]);
            return new Node(arr[left], 0);}
        if (memo[left][right] != null) return memo[left][right];

      //  System.out.print(Arrays.deepToString(memo));
        
        
        int maxLeaf = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;

        for (int i = left; i < right; i++) {
            Node leftSide = mctFromLeafValues(left, i, arr, memo);
            Node rightSide = mctFromLeafValues(i + 1, right, arr, memo);

            minSum = Math.min(minSum, leftSide.minSum + rightSide.minSum + leftSide.maxLeaf * rightSide.maxLeaf);
            maxLeaf = Math.max(maxLeaf, Math.max(leftSide.maxLeaf, rightSide.maxLeaf));
                          // System.out.println(left+" "+right+" "+minSum+" "+maxLeaf);


        }

        memo[left][right] = new Node(maxLeaf, minSum);
        return memo[left][right];
    }
}



