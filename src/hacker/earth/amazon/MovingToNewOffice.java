package hacker.earth.amazon;

import java.util.Scanner;

/**
 * Created by PDeb on 11/10/2017.
 */
public class MovingToNewOffice {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        for (int m = 0; m < testcases; m++) {
            int left = in.nextInt();
            int right = in.nextInt();
            int points = in.nextInt();
            int cutPoints[] = new int[points+1];
            for (int j = 0; j < points+1; j++) {
                cutPoints[j] = in.nextInt();
            }

            int T[][] = new int[points+1][cutPoints[cutPoints.length-1]+1];
            for (int j = 0; j <= cutPoints[cutPoints.length-1]; j++) {
                T[0][j] = 4*j;
            }

            for (int i = 1; i < points+1; i++) {
                for (int j = 1; j < cutPoints[cutPoints.length-1]+1; j++) {
                    if(cutPoints[i] < j)
                    {
                        int cost = (left*(cutPoints[i]-1))+(right*(j-cutPoints[i]));
                        T[i][j] = Math.min(cost+T[i-1][j-cutPoints[i]], T[i-1][j-1]);
                    }
                    else
                        T[i][j] = T[i-1][j];
                }
            }
            for (int i = 0; i < points; i++) {
                for (int j = 0; j <= cutPoints[cutPoints.length-1]+1; j++) {
                    System.out.print(T[i][j]+" ");
                }
                System.out.println();
            }
        }

        int c = -959176711;

    }
}
