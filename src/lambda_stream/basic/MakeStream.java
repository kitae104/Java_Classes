package lambda_stream.basic;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MakeStream {
    public static void main(String[] args) {
        // 스트림을 생성하는 방법
        // Stream<T> Collection.stream() 형태로 변경 가능
        List<Integer> list = Arrays.asList(1,2,3,4,5);                          // 리스트 생성

        Stream<Integer> intStream = list.stream();                              // 컬렉션

        Stream<String> strStream = Stream.of(new String[] {"a", "b", "c"});     // 배열

        Stream<Integer> evenStream = Stream.iterate(0, n -> n+2);       // 0, 2, 4, ...

        Stream<Double> randomStream = Stream.generate(Math::random);           // 람다식

        IntStream iStream = new Random().ints(5);               // 난수 스트림(크기가 5)


    }
}
