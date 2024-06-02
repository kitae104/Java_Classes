package lambda_stream.classes.stream;

import java.util.stream.Stream;

public class StreamEx1{

	public static void main(String[] args) {
        // 1. 컬렉션(List, Set, Map, 배열)을 스트림으로 만들기
        String[] strArr = {"dd", "aaa", "CC", "cc", "b"};
        Stream<String> stream = Stream.of(strArr);

        // 2. 중간 연산(0 ~ n번 수행)
//        Stream<String> filterStream = stream.filter();              // 걸러내기
//        Stream<String> distinctedStream = stream.distinct();        // 중복제거
//        Stream<String> sortedStream = stream.sort();                // 정렬
//        Stream<String> limitedStream = stream.limit(5);  // 스트림 자르기

        // 3. 최종 연산 (1번) -> 결과
        long total = stream.count();
        System.out.println(total);
    }
}
