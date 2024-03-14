package lambda_stream.practice;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamSortCompare {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan).reversed()     // 1. 반별 정렬
                .thenComparing(Comparator.reverseOrder()))               // 2. 기본 정렬
                .forEach(System.out::println);
    }
}
