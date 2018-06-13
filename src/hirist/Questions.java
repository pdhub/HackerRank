package hirist;

public class Questions implements Cloneable{
    public static void main(String[] args) {
        char ch;
        ch = "jo".charAt(0);
        System.out.println(ch);

        Questions q  = new Questions();
        System.out.println(q);

        int acsii[] = {65, 66, 67, 68};
        System.out.println(new String(acsii, 1, 3));

        StringBuffer s = new StringBuffer("Hello World");
        s.insert(6, "Good");
        System.out.println(s);


    }

    public Questions c() throws CloneNotSupportedException {
        return (Questions) super.clone();
    }
}
