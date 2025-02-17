package part1.inheritance.ex2;

public class Test {
    public static void main(String[] args) {
        B b = new B(10, 20);
        B a = new B(100, 200);
        a = b;

        int bb = 10;
        int cc = 100;
        bb = cc;

    }
}
