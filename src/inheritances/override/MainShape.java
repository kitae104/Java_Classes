package inheritances.override;

public class MainShape {
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.draw();

        shape = new Line();  
        shape.draw();
        
        Line line = new Line();
        

        Circle circle = new Circle();
        circle.draw();

        Rect rect = new Rect();
        rect.draw();
        
        
        
    }
}
