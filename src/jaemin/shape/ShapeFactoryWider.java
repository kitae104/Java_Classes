package jaemin.shape;

public class ShapeFactoryWider extends ShapeFactory {

    private final double amp;

    public ShapeFactoryWider(double amp) {
        this.amp = amp;
    }

    public Shape create(String name, double[] data) throws Exception {
        //does the same thing as create in ShapeFactory but all data entry are multiplied by amp // your code (5 lines)
        if(name.equalsIgnoreCase("rectangle")) {
            return new Rectangle(data[0]*amp, data[1]*amp);
        } else if(name.equalsIgnoreCase("circle")) {
            return new Circle(data[0]*amp);
        } else {
            throw new Exception("invalid shape " + name);
        }
    }

}