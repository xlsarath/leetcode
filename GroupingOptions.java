/*  Grouping Options
    Given a number of people n and a number of groups k,
    find the distinct options to form k contiguous groups out of the n people while respecting the following conditions:
        o In each option, the total of group sizes is equal to the number of people.
        o In each option, each group's size should be greater than or equal to te group to its left.
        o The groups formed in each option are distinct, meaning that they differ in at least one group.
          For example, [1, 1, 1, 3] is distinct from [1, 1, 1, 2] but not from [1, 3, 1, 1].
    Example
    people = 8
    groups = 4
        o The 5 distinct options to from 4 groups with 8 people under the rules are:
          [1, 1, 1, 5], [1, 1, 2, 4], [1, 1, 3, 3], [1, 2, 2, 3] and [2, 2, 2, 2].
        o In each option, the groups are distinct and each group's size is greater than or equal to the group to its left.
    Function Description
    Complete the function countOptions in the editor below.
    countOptions has the following parameters:
        int people: an integer that denotes the number of people in the row
        int groups: an integer that denotes the number of groups to form
    Returns:
        int: a long integer that denotes the number of ways that n participants can be divided into k groups satisfying the conditions mentioned above.
 */


import java.util.Scanner;

public class GroupingOptions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int groups = sc.nextInt();

        if (people < groups) {
            System.out.print(0);
            return;
        }

        int[][] dp = new int[people + 1][groups + 1];
        for (int i = 0; i <= people; i++) {
            dp[i][1] = 1;
        }
        dp[0][0] = 1;
        for (int i = 1; i <= people; i++) {
            for (int j = 2; j <= groups; j++) {
                dp[i][j] = dp[i - 1][j - 1];
                if (i >= 2 * j) {
                    dp[i][j] += dp[i - j][j];
                }
            }
        }

        System.out.print(dp[people][groups]);

        backtrack(people, groups, 1);

        System.out.println(count);
       
    }

    private static int count;


    private static void backtrack(int n, int k, int start) {
        if (k == 0) {
            if (n == 0) {
                count++;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            backtrack(n - i, k - 1, i);
        }
    }
}