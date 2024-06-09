package jaemin.shape;

class Rectangle implements Shape {

    private final double base, height;

    Rectangle(double base, double height) {
        //your code//
        this.base = base;
        this.height = height;
    }
   
    public void draw() {
        //prints "Rectangle[w.wwww x h.hhhh]" //your code
        System.out.println("Rectangle[" + String.format("%.5f", base) + " x " + String.format("%.5f", height) + "]");
    }


    public double area() {
        //returns the area // your code
        return base * height;
    }

    public double perimeter() {
    	//returns the perimeter // your code
        return 2 * (base + height);
    }
    
    public void printshape()
    {
        //prints the rectangle perimeter using discrete values (ex: width 7.6 -> 7)// your code
        int w = (int)base;
        int h = (int)height;

        for(int i = 0; i < w; i++) {
            System.out.print("O");
        }
        System.out.print("\n");
        for(int i = 0; i < h - 2; i++) {
            System.out.print("O");
            for(int j = 0; j < w - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("O\n");
        }
        for(int i = 0; i < w; i++) {
            System.out.print("O");
        }
        System.out.print("\n");
    }
}