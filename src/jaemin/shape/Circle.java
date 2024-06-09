package jaemin.shape;

class Circle implements Shape {
    private final double ray;

    Circle(double ray) {
        this.ray = ray;
    }


    public void draw() {
        //prints "Circle[ray:n.nnnnn]"// your code
        System.out.println("Circle[ray:" + String.format("%.5f", ray) + "]");
    }

    public double area() {
        //returns the area// your code
        return ray * ray * Math.PI;
    }

    public double perimeter() {
        //returns the perimeter //your code
        return ray * 2 * Math.PI;
    }

    public void printshape() {
//    	int r = (int)ray; //ray formatted to descrete value (ex. 5.3 ->5)//your code//
//
//        // dist represents distance to the center
//        double dist;
//
//        // for horizontal movement
//        //i should be less then the diameter and more than 0//your code//
//        for(int i = 0; i < 2* r; i++) {
//            System.out.print(" ");
//        }
//
//        // for vertical movement
//        //j should be less then the diameter and more than 0//your code//
//        for(int j = 0; j < 2 * r; j++) {
//            dist = //1st pythagorean theorem applied to the difference(horizontal movement ,radius) and difference(vertical movement ,radius)//your code//
//
//            // dist should be in the range (radius - 0.5)
//            // and (radius + 0.5) to print circles(O)
//            if (/*your code */)
//            //print//yourcode
//            else
//            //print//your code
//
//        System.out.print("\n");


    }


}