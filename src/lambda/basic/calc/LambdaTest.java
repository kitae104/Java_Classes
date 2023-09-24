package lambda.basic.calc;

public class LambdaTest {

    public static void main(String[] args) {
        action((x, y) -> {
            int result = x + y;
            System.out.println("x + y = " + result);
        });

        action((x, y) -> {
            int result = x - y;
            System.out.println("x - y = " + result);
        });
    }

    public static void action(Calculable calculable) {
        int x = 10;
        int y = 20;
        calculable.calculate(x, y);
    }
}
