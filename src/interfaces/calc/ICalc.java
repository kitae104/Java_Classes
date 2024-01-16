package interfaces.calc;

public interface ICalc {

    public static final int MAX = 100;
    int MIN = 1;


    int add(int a, int b);
    public abstract int sub(int a, int b);
    abstract int mul(int a, int b);
    public double div(int a, int b);
}
