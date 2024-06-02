package lambda_stream.classes.lambda;

public class MyFunctionTest {
    public static void main(String[] args) {

        // 익명 내부 클래스를 사용하는 방식
        MyFunction func = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };
        int value = func.max(30, 50);
        System.out.println(value);

        // 람다식을 사용하는 방식
        MyFunction f = (a, b) -> a > b ? a : b;
        System.out.println(f.max(3, 5));
    }
}
