package part1.interfaces.calc;

// 추상 클래스와 인터페이스 비교 및 차이점 이해하기 
public interface ICalc {

    public static final int MAX = 100;
    int MIN = 1;

    public default void test() {
    	System.out.println("Default");
    }

    int add(int a, int b);
    public abstract int sub(int a, int b);
    abstract int mul(int a, int b);
    public double div(int a, int b);
    
    
}
