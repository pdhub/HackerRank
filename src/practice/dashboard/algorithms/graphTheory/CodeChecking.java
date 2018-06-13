package practice.dashboard.algorithms.graphTheory;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by PDeb on 10/25/2017.
 */
class overload {

    int x;
    double y;
    void add(int a, int b) {
        x = a + b;
    }

    void add(double c, double d) {
        y = c + d;
    }

    void add(float a, float b)
    {
        System.out.println("float called");
    }

    void stringMatch(String str)
    {
        System.out.println("String called");
    }

    void stringMatch(Object obj)
    {
        System.out.println("Object called");
    }

    overload() {
        this.x = 0;
        this.y = 0;
    }
}

class Overload_methods {
    public static void main(String args[]) {
        overload obj = new overload();
        int a = 2;
        double b = 3.2;
        obj.add(a, a);
        obj.add(b, b);
        System.out.println(obj.x + " " + obj.y);

        String str = null;
        obj.stringMatch(str);

        /*************************/

        char c[]={'a', '1', 'b' ,' ' ,'A' , '0'};
        for (int i = 0; i < 5; ++i)
        {
            if(Character.isDigit(c[i]))
                System.out.println(c[i]+" is a digit");
            if(Character.isWhitespace(c[i]))
                System.out.println(c[i]+" is a Whitespace character");
            if(Character.isUpperCase(c[i]))
                System.out.println(c[i]+" is an Upper case Letter");
            if(Character.isLowerCase(c[i]))
                System.out.println(c[i]+" is a lower case Letter");
            i=i+3;
        }

        /*****An expression involving byte, int, and literal numbers is promoted to which of these********************************/

        B obj2 = new B();

        obj2.j=2;

        obj2.display();

        Integer a11 = new Integer(10);
        float b22 = 12.0f;
        int z = a11%10;
        float x = b22%10;

        /********************************************/

        StringBuffer c1 = new StringBuffer("Hello");

        c1.delete(0,2);

        System.out.println(c1);

        /****Which of these classes is not included in java.lang***********Array*****************************/

        List<String> list = Arrays.asList("ox", "cow");
        //List<String> sorted = list.stream().sorted(String::compareTo).collect(Collectors.toList());

    }

}

abstract class A {

    int i;

    abstract void display();

}

class B extends A {

    int j;

    void display() {

        System.out.println(j);

    }

}