package lambda_stream.practice;

import java.util.stream.IntStream;

public class StreamOperator {
    public static void main(String[] args) {
        // 중간 연산 : 연산 결과가 스트림인 연산 (필터링, 매핑, 정렬 등)
        // 1. skip() : 처음 n개 요소를 건너뛴 스트림을 리턴
        // 2. limit() : 스트림의 크기를 제한
        IntStream intStream = IntStream.rangeClosed(1, 10);   // 1~10 (10 포함)
        intStream.skip(3).limit(5).forEach(System.out::print); // 4~8 (3개 건너뛰고 5개 출력)
        System.out.println();

        // 3. filter() : 조건에 맞는 요소만으로 구성된 스트림을 리턴
        IntStream intStream2 = IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 6);
        intStream2.distinct().forEach(System.out::print);    // 1 2 3 4 5 6
        System.out.println();

        // 4. distinct() : 중복을 제거한 스트림을 리턴
        IntStream intStream3 = IntStream.rangeClosed(1, 10);
        intStream3.filter(i -> i % 2 == 0).forEach(System.out::print); // 2 4 6 8 10
        System.out.println();

        intStream3 = IntStream.rangeClosed(1, 10);
        intStream3.filter(i -> i % 2 == 0 && i % 3 == 0).forEach(System.out::print); // 6
        System.out.println();

        intStream3 = IntStream.rangeClosed(1, 10);
        intStream3.filter(i -> i % 2 == 0).filter(i -> i % 3 == 0).forEach(System.out::print); // 6
        System.out.println();

        // 5. sorted() : 스트림을 정렬
        IntStream intStream4 = IntStream.of(5, 3, 2, 1, 4);
        intStream4.sorted().forEach(System.out::print);    // 1 2 3 4 5
        System.out.println();


    }
}
