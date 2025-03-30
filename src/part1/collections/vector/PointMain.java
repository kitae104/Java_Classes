package part1.collections.vector;

import java.util.Vector;

public class PointMain {
    public static void main(String[] args) {

        Point p1 = new Point(10, 20);
        Point p2 = new Point(20, 30);
        Point p3 = new Point(30, 40);

        Vector<Point> pointVector = new Vector<>();
        pointVector.add(p1);
        pointVector.add(p2);
        pointVector.add(p3);

        int sumx = 0;
        int sumy = 0;
        for (Point point : pointVector) {
            sumx += point.getX();
            sumy += point.getY();
        }

        System.out.println("X 값들의 합 : " + sumx);
        System.out.println("Y 값들의 합 : " + sumy);
    }
}
