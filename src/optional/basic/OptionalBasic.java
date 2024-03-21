package optional.basic;

import java.util.Optional;

public class OptionalBasic {
    public static void main(String[] args) {
        Optional<String> opt = Optional.of("자바 Optional 객체");
        System.out.println(opt.get());  // 자바 Optional 객체

        Optional<String> opt2 = Optional.empty();   // 빈 객체로 초기화 (null이 아닌 빈 객체)
        System.out.println(opt2);   // Optional.empty

        Optional<String> opt3 = Optional.of("abc");         // null로 초기화
        String s = opt3.orElseThrow(NullPointerException::new);    // null이면 예외 발생

        String s2 = opt3.orElseGet(String::new);  // null이면 빈 문자열 객체 생성

        if(Optional.ofNullable(s).isPresent()) {    // null이 아니면
            System.out.println(s);
        }

        // 같은 표현(메소드 참조 사용)
        Optional.ofNullable(s).ifPresent(System.out::println);  // null이 아니면 출력
    }
}
