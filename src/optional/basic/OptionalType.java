package optional.basic;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalType {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");     // null이 아닌 객체로 초기화
        Optional<Integer> optInt = optStr.map(String::length);     // 길이 반환
        System.out.println("optStr = " + optStr.get());
        System.out.println("optInt = " + optInt.get());

        int result1 = Optional.of("123")                    // null이 아닌 객체로 초기화
                .filter(x -> x.length() > 0)                       // 길이가 0보다 크면
                .map(Integer::parseInt).get();                     // 정수로 변환

        int result2 = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).orElse(-1);         // 길이가 0보다 크지 않으면 -1 반환

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);

        Optional.of("123")                       // null이 아닌 객체로 초기화
                .map(Integer::parseInt)                 // 정수로 변환
                .ifPresent(x -> System.out.printf("result3 = %d%n", x)); // 내용이 존재하는 경우라면 출력

        OptionalInt optInt1 = OptionalInt.of(0);    // 0으로 초기화
        OptionalInt optInt2 = OptionalInt.empty();   // 빈 객체로 초기화

        System.out.println(optInt1.isPresent());     // true
        System.out.println(optInt2.isPresent());     // false

    }
}
