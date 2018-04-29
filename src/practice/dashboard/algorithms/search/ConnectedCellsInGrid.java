package practice.dashboard.algorithms.search;

import java.util.*;

public class ConnectedCellsInGrid {

    private static int res = 0;
    private static Integer max = 1;
    private static int connectedCell(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] != 0 && !visited[i][j]) {
                    max = 1;
                    doDFS(matrix, visited, i, j);
                    if(res < max)
                        res = max;
                    max = 0;
                }
            }
        }
        return res;
    }

    private static void doDFS(int[][] matrix, boolean[][] visited, int row, int col) {
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

        visited[row][col] = true;
        for (int i = 0; i < 8; i++) {
            if(isSafe(matrix, visited, row + rowNbr[i], col + colNbr[i])){
                max++;
                doDFS(matrix, visited, row + rowNbr[i], col + colNbr[i]);
            }
        }
    }

    private static boolean isSafe(int[][] matrix, boolean[][] visited, int row, int col) {
        return (row >= 0 && row < matrix.length) &&
                (col >= 0 && col < matrix[row].length) &&
                !visited[row][col] &&
                matrix[row][col] == 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for(int matrix_i = 0; matrix_i < n; matrix_i++){
            for(int matrix_j = 0; matrix_j < m; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        int result = connectedCell(matrix);
        System.out.println(result);
        in.close();
    }
}

