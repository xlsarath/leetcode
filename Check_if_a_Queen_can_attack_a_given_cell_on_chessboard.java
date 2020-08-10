class Check_if_a_Queen_can_attack_a_given_cell_on_chessboard{


    static boolean canQueenAttack(int qR, int qC, int oR, int oC) 
    { 
    // If queen and the opponent 
    // are in the same row 
    if (qR == oR) 
    return true; 

    // If queen and the opponent  
    // are in the same column 
    if (qC == oC) 
    return true; 

    // If queen can attack diagonally 
    if (Math.abs(qR - oR) == Math.abs(qC - oC)) 
    return true; 

    // Opponent is safe 
    return false; 
    } 

    // Driver code 
    public static void main(String[] args) 
    { 
    int qR = 1, qC = 1; 
    int oR = 3, oC = 2; 
    if (canQueenAttack(qR, qC, oR, oC)) 
    System.out.println("Yes"); 
    else
    System.out.println("No"); 
    } 


}