package jaemin.shape;

public class ShapeFactory {

  
    public Shape create(String name, double[] data) throws Exception {
        
        //given a name makes a new object of that type (rectangle or circle) with the data given 
    	//(in retangle case data contains base and height, in circle case it contains radius)
        // throws exeption if not valid shape (ex: "invalid shape oval")// your code (5 lines)
        if(name.equalsIgnoreCase("rectangle")) {
            return new Rectangle(data[0], data[1]);
        } else if(name.equalsIgnoreCase("circle")) {
            return new Circle(data[0]);
        } else {
            throw new Exception("invalid shape " + name);
        }
    }


}