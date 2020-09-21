//time complexity : O(n)
//space complexity : O(1)
public class Robot_Bounded_In_Circle_1041 {

    public static boolean isRobotBounded(String instructions) {

        int cur[] = new int[]{0,0};
        int dirs[][] = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int dir = 0; // 0:north(up), 1: right, 2: down, 3: left

        for(char ch : instructions.toCharArray()){

            if(ch == 'G'){
                cur[0] += dirs[dir][0];
                cur[1] += dirs[dir][1];
            } else if (ch == 'L')
                dir += (dir + 3) % 4;
             else
             dir += (dir + 1) % 4;
        }

        if(cur[0] == 0 && cur[1] == 0) return true;

        if(dir == 0 && !(cur[0] == 0 && cur[1] == 0)) return false;

        return true;
}
public static void main(String[] args) {
    System.out.println(isRobotBounded("GL"));
}
}