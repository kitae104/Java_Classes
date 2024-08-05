package jaemin.packages.objects;

public class ObjectProperty {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        System.out.println(p1 == p2); // false
        System.out.println(p1.equals(p2)); // true

        String s1 = new String("Hello");
        String s2 = new String("Hello");

        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // true


    }
}
