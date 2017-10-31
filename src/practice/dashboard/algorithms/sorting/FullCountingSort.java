package practice.dashboard.algorithms.sorting;

import java.util.*;

/**
 * Created by PDeb on 10/30/2017.
 */
public class FullCountingSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalInputs = in.nextInt();
        String helperArray[] = new String[totalInputs];
        for (int i = 0; i < helperArray.length; i++) {
            helperArray[i] = "";
        };

        int maxAccompanyingInteger = 0;

        for (int i = 0; i < totalInputs; i++) {
            int accompnyingInteger = in.nextInt();
            String word = in.next();
            if(i < totalInputs/2)
                helperArray[accompnyingInteger] += "-";
            else
                helperArray[accompnyingInteger] += word;
            helperArray[accompnyingInteger]+=" ";

            if(maxAccompanyingInteger < accompnyingInteger)
                maxAccompanyingInteger = accompnyingInteger;
        }

        for (int i = 0; i <= maxAccompanyingInteger ; i++) {
            System.out.print(helperArray[i]);
        }
    }
}
