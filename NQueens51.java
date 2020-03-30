import java.util.LinkedList;
import java.util.List;
//time complexity : N!
//sapce complexity : NxN
//leet code exectuion : yes
//steps : before placing queen in the n(i,j) location check for vertical and diagonal safe locations.if it's not safe remove the queen from state and increment row num and continue backtracking. if loc is safe add queen to stack and continue backtracking once cursor reaching n add entire list into result list and return.
class NQueens51{


    public List<List<String>> solveNQueens(int n) {

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> state = new LinkedList<>();
        backtrack(result,state,0,n);
        System.out.println(result);
        return genBoards(result,n);
    }


    private List<List<String>> genBoards(List<List<Integer>> result, int n) {
        
        StringBuilder sb = new StringBuilder();
        List<List<String>> boards = new LinkedList<>();
        for(int i=0;i<n;i++){
            sb.append(".");
        }
        for(List<Integer> state : result){
            List<String> board = new LinkedList<>();
            for(int col : state){
                sb.replace(col,col+1 , "Q");
                board.add(sb.toString());
                sb.replace(col, col+1, ".");
            }
            boards.add(board);
        }
    return boards;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> state, int row, int n) {
    
        if(row==n) {
            result.add(new LinkedList<>(state));
            return;
        }

        for(int col=0;col<n;col++){
        if(verticalSafe(state,row,col,n) && diagonalSafe(state,row,col,n)){
            state.add(col);
            backtrack(result, state, row+1, n);
            state.remove(state.size()-1);
        }
    }
    }

    private boolean diagonalSafe(List<Integer> state, int row, int col, int n) {
        int i = row-1;
        while(i>=0 ){
            if(state.get(i)==col){
                return false;
            }
            i--;
        }
        return true;
    }

    private boolean verticalSafe(List<Integer> state, int row, int col, int n) {
        int i = row-1,j = col-1;
        while(i>=0 && j>=0){
            if(state.get(i)==j){
                return false;
            }
            i--;
            j--;
        }
        i = row-1;
        j=col+1;
        while(i>=0 && j<n){
            if(state.get(i)==j){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {

        NQueens51 q = new NQueens51();

        System.out.println(q.solveNQueens(6));
    
}

}