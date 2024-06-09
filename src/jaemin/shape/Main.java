package jaemin.shape;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
        	Scanner scanner = new Scanner(System.in);
        	System.out.println("Insert a multiplication factor (as a double)");
        	double value;
        	// gets the value from system input // your code
        	value = scanner.nextDouble();

            System.out.println("Give me a shape to generate (rectange or circle)");
            // gets the name of the shape form system input in a variable called shapescan// your code
            String shapescan = scanner.next();

            double sdata[] = {0,0};
            ShapeFactory factory = new ShapeFactoryWider(value);

            /*checks whether shapescan is rectangle//your code*/
            if(shapescan.equalsIgnoreCase("rectangle") ) {
            	System.out.println("Insert width");
            	//puts input in sdata[0]// your code
                sdata[0] = scanner.nextDouble();
            	scanner.nextLine();
            	System.out.println("Insert height");
            	//puts input in sdata[1]// your code
                sdata[1] = scanner.nextDouble();
            	scanner.nextLine();
            }
            /*checks whether shapescan is circle//your code */
            if(shapescan.equalsIgnoreCase("circle")){
            	System.out.println("Insert radius");
            	//puts input in sdata[0]// your code
                sdata[0] = scanner.nextDouble();
            	scanner.nextLine();
            }

            Shape myshape = factory.create(shapescan, sdata);
            myshape.draw();
            myshape.printshape();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}