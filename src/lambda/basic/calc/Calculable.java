package lambda.basic.calc;

@FunctionalInterface
public interface Calculable {
    // 추상 메소드
    void calculate(int x, int y);
}
