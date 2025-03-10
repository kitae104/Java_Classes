package part1.override.dynamicbinding;

public class MainShape {
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.draw();

//        shape = new Line();  
//        shape.draw();
        
        Line line = new Line();
        line.draw();

        Circle circle = new Circle();
        circle.draw();

        Rect rect = new Rect();
        rect.draw();
        
        // 타입 변환
        int a = 10;
        double d = 1.1;

        d = a;
        a = (int)d;       
        
    }
}
