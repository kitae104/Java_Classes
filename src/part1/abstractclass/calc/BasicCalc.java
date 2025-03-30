package part1.abstractclass.calc;

public abstract class BasicCalc extends ACalc{

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return 0;
    }

}
