package inheritances.basic;

public class MainPoint {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        System.out.println(p1.toString());
        p1.printInfo();
        System.out.println();

        ColorPoint cp1 = new ColorPoint(10, 20, "RED");
        //cp1.printInfo();
        cp1.printColorInfo();
    }
}
