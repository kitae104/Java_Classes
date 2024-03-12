package lambda_stream.practice;

import java.beans.Introspector;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCollection {
    public static void main(String[] args) {

        // 1. 리스트를 스트림으로 만들기
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();
        intStream.forEach(System.out::print);       // 메서드 참조
        System.out.println();

        Stream<String> strStream = Stream.of("a", "b", "c");
        strStream.forEach(System.out::print);
        System.out.println();

        // 2. 배열을 스트림으로 만들기
        String[] strArr = new String[] {"aa", "bb", "cc", "dd", "ee"};
        Stream<String> strStream2 = Stream.of(strArr);
        strStream2.forEach(System.out::print);
        System.out.println();

        Stream<String> strStream3 = Arrays.stream(strArr);
        strStream3.forEach(System.out::print);
        System.out.println();

        int[] intArr = {1,2,3,4,5};
        IntStream intStream1 = Arrays.stream(intArr);
//        System.out.println(intStream1.average());           // 마지막 연산
        System.out.println(intStream1.sum());                 // 마지막 연산
//        intStream1.forEach(System.out::print);              // 마지막 연산
//        System.out.println();

        // 3. 스트림 만들기

    }
}
