package workday2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexToMatchEmail {
    public static void main(String[] args) {
        String emails[] = {"julia@hackerrank.com",
        "julia_@hackerrank.com",
        "julia_0@hackerrank.com",
        "julia0_@hackerrank.com",
        "julia@gmail.com"};

        for (String email: emails){
            System.out.println(matches(email));
        }
    }

    static boolean matches(String email){
            String regex = "^([a-z]{0,5}+)(_?+)([0-9?]{0,4}+)(@hackerrank.com)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}


