package crackcodeinterview;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        int n = 12;
        System.out.println(ways(n, coins));
    }

    static int ways(int n, int[] coins) {
        int[][] T = new int[coins.length + 1][n + 1];
        // if amount=0 then just return empty set to make the change
        for (int i = 0; i <= coins.length; i++) {
            T[i][0] = 1;
        }
        // if no coins given, 0 ways to change the amount
        for (int i = 0; i <= n; i++) {
            T[0][i] = 0;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i-1])
                    // reduce the amount by coin value and
                    // use the subproblem solution (amount-v[i]) and
                    // add the solution from the top to it
                    T[i][j] = T[i-1][j] + T[i][j-coins[i-1]];
                else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        return T[coins.length][n];
    }
}
