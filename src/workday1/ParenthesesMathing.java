package workday1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesesMathing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        String[] input = new String[testCases];
        for (int i = 0; i < testCases; i++) {
            input[i] = in.next();
        }
        String res[] = braces(input);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    static String[] braces(String[] values) {
        Map<String, String> map = new HashMap<>();
        map.put("{", "}");
        map.put("[", "]");
        map.put("(", ")");

        String result[] = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            String str = values[i];
            Stack<String> stack = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                String brace = str.charAt(j)+"";
                if (!stack.isEmpty() && map.get(stack.peek())!= null && map.get(stack.peek()).equals(brace)){
                    stack.pop();
                }else
                    stack.push(brace);
            }
            if (stack.isEmpty()){
                result[i] = "YES";
            }else
                result[i] = "NO";
        }
        return result;
    }
}
