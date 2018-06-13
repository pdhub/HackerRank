package practice.dashboard.algorithms.DynamicProgramming;

import java.util.*;

public class LongestCommonSubsequence {

    static int[] longestCommonSubsequence(int[] a, int[] b) {

        int aLen = a.length;
        int bLen = b.length;
        int dp[][] = new int[aLen + 1][bLen + 1];

        int maxLen = 0;
        for(int i = 1; i <= aLen; i++){
            for(int j = 1; j <= bLen; j++){
                if(a[i - 1] == b[j - 1]){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    if(maxLen < dp[i][j])
                        maxLen = dp[i][j];
                }
            }
        }

        int LCS[] = new int[maxLen];
        populateLCS(a, b, dp, LCS);
        return LCS;
    }

    private static void populateLCS(int[] a, int[] b, int[][] dp, int[] lcs) {
        int m = a.length;
        int n = b.length;
        int index = lcs.length - 1;

        while (m > 0 && n > 0 && index > 0){
            if (a[m - 1] == b[n - 1]){
                lcs[index] = a[m - 1];
                index--;
                m--;
                n--;
            } else if(dp[m - 1][n] > dp[m][n - 1])
                m--;
            else
                n--;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int[] result = longestCommonSubsequence(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
