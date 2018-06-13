package practice.dashboard.algorithms.search;

import java.util.Scanner;
import java.util.Stack;

public class ShortPalindrome {
    static int shortPalindrome(String s) {
        Double tupleCount = 0d;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Stack<Character> stack = new Stack<Character>();
            stack.push(c);
            for (int j = i + 1; j < s.length(); j++) {
                stack.push(s.charAt(j));
                checkPalindromicPair(s, stack, j+1);
                if(stack.isEmpty()) {
                    tupleCount++;
                }
                stack.clear();
                stack.push(c);
            }
        }
        tupleCount = tupleCount % (Math.pow(10, 9) + 7);
        return tupleCount.intValue();
    }

    private static void checkPalindromicPair(String s, Stack<Character> stack, int i) {
        System.out.println("trying to clear " + stack.toString());
        for (int j = i; j < s.length(); j++) {
            Character c = s.charAt(j);
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            if(stack.isEmpty())
                return;
        }
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.next();
//        int result = shortPalindrome(s);
//        System.out.println(result);
//        in.close();


        Scanner in = new Scanner(System.in);

        int m = 1000000007;

        String str = in.nextLine();

        int first[] = new int[26];

        int second[][] = new int[26][26];

        int third[] = new int[26];

        int count = 0;

        for(int i=0;i<str.length();i++){

            int current = str.charAt(i) - 'a';

            count += third[current]%m;

            count = count%m;

            for(int j=0;j<26;j++){

                third[j] += second[j][current]%m;

                third[j] = third[j]%m;

            }

            for(int j=0;j<26;j++){

                second[j][current] += first[j]%m;

                second[j][current] = second[j][current]%m;

            }

            first[current] ++;

            first[current] = first[current]%m;

        }

        System.out.println(count);


    }
}
