package part1.inheritance.ex3;

public class TestMain {
    public static void main(String[] args) {
        Point p = new Point(10, 20);
        System.out.println(p);

        ColorPoint cp = new ColorPoint(10, 20, "RED");
        System.out.println(cp);
    }
}
