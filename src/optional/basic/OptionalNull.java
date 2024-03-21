package optional.basic;

import java.util.Optional;

public class OptionalNull {
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println("arr.length = " + arr.length);  // 0

        int[] arr2 = null;
//        System.out.println("arr2.length = " + arr2.length);  // NullPointerException

//        Optional<String> opt = null;   // null로 초기화 가능
        Optional<String> opt = Optional.empty();   // 빈 객체로 초기화 (null이 아닌 빈 객체)
        System.out.println(opt);   // Optional.empty
//        System.out.println(opt.get());  // NoSuchElementException

        String str = "";
        str = opt.orElse("빈 문자열");  // null이면 "빈 문자열" 반환
        System.out.println("str = " + str);  // 빈 문자열

        str = opt.orElseGet(() -> new String());    // null이면 빈 문자열 객체 생성
        System.out.println("str = " + str);         // 빈 문자열

        str = opt.orElseGet(String::new);    // null이면 빈 문자열 객체 생성
        System.out.println("str = " + str);  // 빈 문자열

    }

}
