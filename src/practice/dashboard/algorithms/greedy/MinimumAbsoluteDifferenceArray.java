package practice.dashboard.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by PDeb on 11/5/2017.
 */
public class MinimumAbsoluteDifferenceArray {
    static int minimumAbsoluteDifference(int n, int[] arr) {

        Arrays.sort(arr);
        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if((Math.abs(arr[i]-arr[i-1]))<minVal)
                minVal = Math.abs(arr[i]-arr[i-1]);
        }
        return minVal;
        /*int currentPosMax = Integer.MIN_VALUE, currentPrevPosMax = Integer.MIN_VALUE, currentNegMin = Integer.MAX_VALUE, currentNextNegMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            if(number > currentPosMax ) {
                currentPrevPosMax = currentPosMax;
                currentPosMax = arr[i];
            }
            if(number < currentNegMin){
                currentNegMin = currentNextNegMin;
                currentNextNegMin = number;

            }
        }

        //System.out.println(" currentNegMin : "+currentNegMin+" currentNextNegMin : "+currentNextNegMin+ " currentPrevPosMax " + currentPrevPosMax +" currentPosMax : "+currentPosMax+" ");

        //If there is only one positive number and one negative number
        if(currentPrevPosMax == Integer.MIN_VALUE && currentNextNegMin == Integer.MAX_VALUE)
        {
            return Math.abs(currentNegMin - currentPosMax);
        }
        //If there is one positive but multiple negative
        if (currentPrevPosMax == Integer.MIN_VALUE){
            return Math.min(Math.abs(currentNegMin - currentNextNegMin), Math.abs(currentNextNegMin-currentPosMax));
        }

        //If there is one negative number but multiple positives
        if(currentNextNegMin == Integer.MAX_VALUE){
            return Math.min(Math.abs(currentNegMin-currentPrevPosMax), Math.abs(currentPrevPosMax-currentPosMax));
        }

        return Math.min(Math.min(Math.abs(currentNegMin-currentNextNegMin), Math.abs(currentNextNegMin-currentPrevPosMax)), Math.abs(currentPrevPosMax - currentPosMax));*/
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = minimumAbsoluteDifference(n, arr);
        System.out.println(result);
        in.close();
    }
}
