package lambda_stream.practice;

import java.beans.Introspector;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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

        // 3. 난수 요소를 갖는 스트림 생성하기
        IntStream intStream2 = new Random().ints();                 // 랜덤 무한 스트림
        intStream2.limit(5).forEach(System.out::println);  // 5개 제한

        IntStream intStream3 = new Random().ints(5);    // 5개의 랜덤 스트림
        intStream3.forEach(System.out::println);

        // 4. 특정 범위의 정수 스트림 생성하기
        IntStream intStream4 = IntStream.range(1, 5);    // 1~4 끝을 포함하지 않음
        intStream4.forEach(System.out::print);
        System.out.println();

        IntStream intStream5 = IntStream.rangeClosed(1, 5);    // 1~5 끝을 포함
        intStream5.forEach(System.out::print);
        System.out.println();


    }
}
