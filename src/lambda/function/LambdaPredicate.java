package lambda.function;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaPredicate {
    public static void main(String[] args) {
        //===============================================================
        // Function 결합 (andThen, compose) - 입력과 출력이 같아야 함
        //===============================================================
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i);

        // 함수를 연결하기 위해서는 입력과 출력을 확인 해야 한다.
        Function<String, String> h = f.andThen(g);          // f를 먼저 수행하고 g를 수행(기본)
        Function<Integer, Integer> h2 = f.compose(g);       // g를 먼저 수행하고 f를 수행

        System.out.println(h.apply("FF"));   // 단계별 처리 : "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2));     // 2 -> "10" -> 16

        //===============================================================
        // 항등 함수(identity function) : 입력 값을 그대로 리턴
        //===============================================================
        Function<String, String> f2 = x -> x;    // 항등 함수
        System.out.println(f2.apply("AAA"));     // AAA가 그대로 출력

        //===============================================================
        // Predicate 결합 (and, or, negate)
        //===============================================================
        Predicate<Integer> p = i -> i < 100;    // i가 100보다 작은지 검사
        Predicate<Integer> q = i -> i < 200;    // i가 200보다 작은지 검사
        Predicate<Integer> r = i -> i % 2 == 0; // i가 짝수인지 검사

        Predicate<Integer> notP = p.negate();   // i가 100보다 큰지 검사(i >= 100)
        Predicate<Integer> all = notP.and(q.or(r));     // 100 <= i && (i < 200 || i % 2 == 0)
        Predicate<Integer> all2 = notP.and(q).or(r);    // 100 <= i && i < 200 || i % 2 == 0

        System.out.println(all.test(2));          // false
        System.out.println(all2.test(2));         // true

        //===============================================================
        // Predicate isEqual(등가 비교) - static 메서드
        //===============================================================
        String str1 = "abc";
        String str2 = "abc";

        // str1과 str2가 같은지 비교한 결과 확인
        Predicate<String> p2 = Predicate.isEqual(str1);
        boolean result = p2.test(str2);
        System.out.println(result);     // true

        // 축약 표시
        boolean result2 = Predicate.isEqual(str1).test(str2);
        System.out.println(result2);    // true
    }
}
