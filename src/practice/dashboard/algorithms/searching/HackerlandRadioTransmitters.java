package practice.dashboard.algorithms.searching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by PDeb on 10/31/2017.
 */
public class HackerlandRadioTransmitters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numHouses = in.nextInt();
        int range = in.nextInt();
        int houses[] = new int[numHouses];
        for (int i = 0; i < numHouses; i++) {
            houses[i] = in.nextInt();
        }
        Arrays.sort(houses);

        int minRangeHouse = houses[0];
        int towersPosted = 0;
        int currentTowerPostedAt = 0;
        int housesCovered = 0;
        for (int i = 1; i < houses.length; i++) {
            //System.out.println("Min range house "+minRangeHouse);
            while (i < houses.length && houses[i] - minRangeHouse <= range)
            {
                i++;
            }
            towersPosted++;
            currentTowerPostedAt = houses[--i];
            //System.out.println("Tower posted at "+currentTowerPostedAt);
            while (i < houses.length && houses[i] - currentTowerPostedAt <= range)
            {
                i++;
            }
            if(i< houses.length) {
                minRangeHouse = houses[i];
                housesCovered = i;
            }
            //System.out.println("Star next min range house from "+minRangeHouse);

            //System.out.println("Houses covered : "+housesCovered);
        }

        towersPosted = housesCovered!=houses.length?towersPosted+1:towersPosted;
        System.out.println(towersPosted);

    }
}
