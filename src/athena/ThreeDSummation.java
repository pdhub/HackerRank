package athena;

import java.util.Scanner;

public class ThreeDSummation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();
        while (numTestCases-- > 0){
            int matrixSize = in.nextInt();
            int matrix[][][] = new int[matrixSize+1][matrixSize+1][matrixSize+1];
            int prefixSum[][][] = new int[matrixSize+1][matrixSize+1][matrixSize+1];
            int numberOfOperations = in.nextInt();
            while (numberOfOperations-- > 0){
                String operation = in.next();
                if (operation.equalsIgnoreCase("update")){
                    int x = in.nextInt();
                    int y = in.nextInt();
                    int z = in.nextInt();
                    int val = in.nextInt();
                    matrix[x][y][z] = val;
                    updatePrefixSumArray(prefixSum, matrix, matrixSize);
                }else if (operation.equalsIgnoreCase("query")){
                    int x1 = in.nextInt();
                    int y1 = in.nextInt();
                    int z1 = in.nextInt();
                    int x2 = in.nextInt();
                    int y2 = in.nextInt();
                    int z2 = in.nextInt();
                    int res = prefixSum[x2][y2][z2]+prefixSum[x1][y1][z1]-
                            prefixSum[x1][y2][z2]-prefixSum[x2][y1][z2]-prefixSum[x2][y2][z1];
                    //sum[x2][y2] + sum[x1][y1] - sum[x1][y2] - sum[x2][y1]

                    System.out.println(res);
                }

            }
        }
    }

    private static void updatePrefixSumArray(int[][][] S, int a[][][], int matrixLen){
        for (int i = 1; i <= matrixLen; i++)
            for (int j = 1; j <= matrixLen; j++)
                for (int k = 1; k <= matrixLen; k++)
                    S[i][j][k] = S[i - 1][j][k] + S[i][j - 1][k] + S[i][j][k - 1]
                            - S[i - 1][j - 1][k] - S[i][j - 1][k - 1] - S[i - 1][j][k - 1]
                            + S[i - 1][j - 1][k - 1] + a[i - 1][j - 1][k - 1];
    }
}
