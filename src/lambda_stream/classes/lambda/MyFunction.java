package lambda_stream.classes.lambda;

@FunctionalInterface        // 함수형 인터페이스는 하나의 추상 메소드만 가져야 한다.
public interface MyFunction {
    public abstract int max(int a, int b);
}
