package codefights;

public class Zigzag {
    public static void main(String[] args) {
        //int[] a = {9, 8, 8, 5, 3, 5, 3, 2, 8, 6};
        //int[] a = {4, 4};
        int[] a = {2, 1, 4, 4, 1, 4, 4, 1, 2, 0, 1, 0, 0, 3, 1, 3, 4, 1, 3, 4};
        System.out.println(zigzag(a));
    }

    static int zigzag(int[] arr) {
        int n = arr.length;
        int Z[][] = new int[n][2];

        // initialize all values with 1
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 2; j++)
                Z[i][j] = 1;

        // Depending on the first difference initialize
        // the second term as well
        if (arr[1] > arr[0])
            Z[1][0] = 2;
        else
            Z[1][1] = 2;

        // Iterate over the array
        for (int i = 2; i < n; i++) {

            // Case 1
            if (arr[i] > arr[i - 1]) {
                // either continue the old sequence or extend
                // depending on which is bigger
                Z[i][0] = Math.max(Z[i - 1][0], 1 + Z[i - 1][1]);
            }
            else if (arr[i] < arr[i - 1])
                Z[i][1] = Math.max(Z[i - 1][1], 1 + Z[i - 1][0]);

            else {
                Z[i][0] = Z[i - 1][0];
                Z[i][1] = Z[i - 1][1];
            }
        }

        // find the maximum of both the last elements in the two rows
        return Math.max(Z[n - 1][0], Z[n - 1][1]);
    }
}
