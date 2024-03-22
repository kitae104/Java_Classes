package lambda_stream.lastoper;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamReduce2 {
    public static void main(String[] args) {
        // 문자열 배열 생성
        String[] strArr = {"Inheritance", "Java", "Lambda", "Stream", "OptionalDouble", "IntStream", "count", "sum"};

        // 병렬 스트림으로 전환
        Stream.of(strArr)
                .parallel()                         // 병렬 스트림으로 전환
                .forEach(System.out::println);      // forEach() 출력 - 최종 연산이므로 스트림을 닫는다.

        // 모든 요소가 조건에 맞는지 확인
        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);// noneMatch() : 모든 요소가 조건에 맞지 않는지 확인
        System.out.println("noneMatch() : " + noEmptyStr);

        // 첫 번째로 나오는 요소를 반환
        Optional<String> sWord = Stream.of(strArr)
                .filter(s -> s.charAt(0) == 's' || s.charAt(0) == 'S')
                .findFirst();
        System.out.println("findFirst() : " + sWord.get());

        // Stream<String[]>을 IntStream으로 변환 --> 최종 연산의 경우 1회만 사용 가능 --> 다시 생성해야 함
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        // reduce() 메소드를 이용하여 갯수 세기
        int count = intStream1.reduce(0, (a, b) -> a + 1);
        System.out.println("count = " + count);

        // reduce() 메소드를 이용하여 합계 구하기
        int sum = intStream2.reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        // reduce() 메소드를 이용하여 최대값 구하기
        OptionalInt max = intStream3.reduce(Integer::max);
        System.out.println("max = " + max.getAsInt());

        // reduce() 메소드를 이용하여 최소값 구하기
        OptionalInt min = intStream4.reduce(Integer::min);
        System.out.println("min = " + min.getAsInt());

    }
}
