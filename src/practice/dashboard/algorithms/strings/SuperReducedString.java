package practice.dashboard.algorithms.strings;

import java.util.Scanner;

/**
 * Created by PDeb on 10/29/2017.
 */
public class SuperReducedString {
    static String super_reduced_string(String s){
        String s2 = " ";
        for (int i = 0; i < s.length(); i++) {
            if(s2.charAt(s2.length()-1)!=s.charAt(i))
                s2+=s.charAt(i);
            else
                s2 = s2.substring(0, s2.length()-1);
        }
        return s2.trim().length()>0?s2.trim():"Empty String";
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
