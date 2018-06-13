package workday1;

public class ProductOfNonOverLapping {


    public static void main(String[] args) {
        System.out.println(getScore("acdapmpomp"));
    }

    static int getScore(String s) {
        int prodMax = -1;
        int resArr[][] = longestPalindromicSubsequence(s);
        for (int i = 0; i < s.length() - 1; i++) {
            int tempProd = resArr[0][i] * resArr[i + 1][s.length() - 1];
            if (prodMax <= tempProd)
                prodMax = tempProd;
        }
        return prodMax;
    }

    static int[][] longestPalindromicSubsequence(String seq)
    {
        int n = seq.length();
        int i, j, cl;
        int resArr[][] = new int[n][n];

        for (i = 0; i < n; i++)
            resArr[i][i] = 1;

        for (cl=2; cl<=n; cl++)
        {
            for (i=0; i<n-cl+1; i++)
            {
                j = i+cl-1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    resArr[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    resArr[i][j] = resArr[i+1][j-1] + 2;
                else
                    resArr[i][j] = Math.max(resArr[i][j-1], resArr[i+1][j]);
            }
        }
        return resArr;
    }
}
