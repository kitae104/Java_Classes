package lambda_stream.practice;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStream {
    public static void main(String[] args) {
        // 1 람다식을 소스로 하는 스트림 생성 (UnaryOperator<T>를 이용한 무한 스트림 생성)
        Stream<Integer> evenStrearm = Stream.iterate(0, n -> n + 2).limit(5);
        evenStrearm.forEach(System.out::println);

        // 2 generate()를 이용한 무한 스트림 생성(Supplier<T>를 이용한 무한 스트림 생성)
        Stream<Double> randomStream = Stream.generate(Math::random).limit(5);
        randomStream.forEach(System.out::println);

        Stream<Integer> oneStream = Stream.generate(() -> 1).limit(5);
        oneStream.forEach(System.out::println);

    }
}
