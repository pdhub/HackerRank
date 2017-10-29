package practice.dashboard.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by PDeb on 10/29/2017.
 */
public class GradingStudents {

    static int[] solve(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            int gradeValue = grades[i];
            if (gradeValue < 38 || gradeValue % 5 == 0)
                continue;
            else {
                int nextMultipleOf5 = ((gradeValue / 5) + 1) * 5;
                if ((nextMultipleOf5 - gradeValue) < 3)
                    grades[i] = nextMultipleOf5;
            }
        }
        return grades;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for (int grades_i = 0; grades_i < n; grades_i++) {
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
    }
}

