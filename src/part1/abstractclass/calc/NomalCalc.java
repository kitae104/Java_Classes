package part1.abstractclass.calc;

public class NomalCalc extends BasicCalc {
    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public double div(int a, int b) {
        return 0;
    }
}
