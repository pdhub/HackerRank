package practice.dashboard.algorithms.strings;

import java.util.Scanner;

public class HackerRankInString {
    static String hackerrankInString(String s) {
        String HACKER_RANK = "hackerrank";
        if(s.length() < HACKER_RANK.length())
            return "NO";
        int charIndexToSearch = 0;
        int positionToSeachFrom = 0;
        String res = "";
        while(charIndexToSearch < HACKER_RANK.length() && positionToSeachFrom < s.length()){
            while(positionToSeachFrom < s.length()){
                if(s.charAt(positionToSeachFrom) == HACKER_RANK.charAt(charIndexToSearch)){
                    res += s.charAt(positionToSeachFrom) + "";
                    charIndexToSearch++;
                    positionToSeachFrom++;
                    break;
                }else{
                    positionToSeachFrom++;
                }
            }
        }
        if(res.equals(HACKER_RANK))
            return "YES";
        return "NO";

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = hackerrankInString(s);
            System.out.println(result);
        }
        in.close();
    }
}
