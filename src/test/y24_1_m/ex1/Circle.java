package test.y24_1_m.ex1;

abstract class Shape {
    public void paint() {
        draw();
    }

    abstract public void draw();
}

public class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    double getArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("반지름 = " + radius);
    }

    public static void main(String[] args) {
        Circle c = new Circle(10);
        c.paint();
    }
}