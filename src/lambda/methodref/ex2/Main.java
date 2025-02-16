package lambda.methodref.ex2;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

// 메소드 참조(Method Reference)는 람다식을 더 간결하게 표현하는 방법이다.
public class Main {
    public static void main(String[] args) {
        // 같은 결과 출력
        calculator((s1, s2) -> s1 + s2, "Hello, ", "World!");
        calculator((s1, s2) -> s1.concat(s2), "Hello, ", "World!");
        calculator(String::concat, "Hello, ", "World!");

        BinaryOperator<String> b1 = (s1, s2) -> s1 + s2;
        BinaryOperator<String> b2 = (s1, s2) -> s1.concat(s2);
        BinaryOperator<String> b3 = String::concat;
        System.out.println(b1.apply("Hello, ", "World!"));
        System.out.println(b2.apply("Hello, ", "World!"));
        System.out.println(b3.apply("Hello, ", "World!"));

        BiFunction<String, String, String> f1 = (s1, s2) -> s1 + s2;
        BiFunction<String, String, String> f2 = String::concat;
        System.out.println(f1.apply("Hello, ", "World!"));
        System.out.println(f2.apply("Hello, ", "World!"));

        UnaryOperator<String> u1 = (s1) -> s1.toUpperCase();
        UnaryOperator<String> u2 = String::toUpperCase;
        System.out.println(u1.apply("Hello, World!"));
        System.out.println(u2.apply("Hello, World!"));

        String result = "HongGilDong".transform(u1);
        System.out.println(result);

        result = "HongGilDong".transform(String::toLowerCase);
        System.out.println(result);

        Function<String, Boolean> f0 = String::isEmpty;
        boolean resultBoolean = result.transform(f0);
        System.out.println(resultBoolean);
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }
}
