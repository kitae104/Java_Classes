package part1.abstractclass.calc;

public class MainCalc {
    public static void main(String[] args) {
        NomalCalc nc = new NomalCalc();
        int a = 10;
        int b = 20;

        int result = nc.add(a, b);
        System.out.println(a + " + " + b + " = " + result);
    }
}
