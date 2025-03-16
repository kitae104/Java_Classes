package statics;

public class StaticClass {

    public static final int MAX = 100;   // 상수


    int a = 1;
    static int b = 2;

    public void printA(){
        System.out.println("AAA : " + a);
    }
    
    public static void printB(){
        System.out.println("BBB : " + b);
    }
}
