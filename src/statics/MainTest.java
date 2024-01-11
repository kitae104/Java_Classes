package statics;

public class MainTest {

    public static void main(String[] args) {

        MainTest mt = new MainTest();

        System.out.println(Math.abs(-10));

        int a = 10;
        int b = 20;
        int c = add(a, b);
        System.out.println(c);
    }

    private static int add(int a, int b) {
        return a + b;
    }
}
