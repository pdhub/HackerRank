package practice.dashboard.algorithms.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by PDeb on 11/5/2017.
 */
public class CoinChange {

    public static int minimumCoinBottomUp(int total, int coins[]){
        return 0;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int numCoins = in.nextInt();
        in.nextLine();
        int coins[] = new int[numCoins];
        for (int i = 0; i < numCoins; i++) {
            coins[i] = in.nextInt();
        }
        in.nextLine();

        int numWays = minimumCoinBottomUp(sum, coins);
        System.out.println(numWays);
    }
}
