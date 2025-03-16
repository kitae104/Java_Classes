package part1.inheritance.ex1;

public class MainPoint {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        System.out.println(p1.toString());
        
        System.out.println(p1);

        ColorPoint cp1 = new ColorPoint(10, 20, "RED");
        //cp1.printInfo();
        System.out.println(cp1);
    }
}
