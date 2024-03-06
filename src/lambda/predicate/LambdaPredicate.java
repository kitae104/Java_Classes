package lambda.predicate;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaPredicate {
    public static void main(String[] args) {
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i);

        Function<String, String> h = f.andThen(g);
        Function<Integer, Integer> h2 = f.compose(g);

        System.out.println(h.apply("FF"));   // "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2));     // 2 -> "10" -> 16

        Function<String, String> f2 = x -> x;    // 항등 함수
        System.out.println(f2.apply("AAA"));     // AAA가 그대로 출력

        Predicate<Integer> p = i -> i < 100;    // i가 100보다 작은지 검사
        Predicate<Integer> q = i -> i < 200;    // i가 200보다 작은지 검사
        Predicate<Integer> r = i -> i % 2 == 0; // i가 짝수인지 검사
        Predicate<Integer> notP = p.negate();   // i가 100보다 큰지 검사(i >= 100)

        Predicate<Integer> all = notP.and(q.or(r));     // i >= 100 && (i < 200 || i % 2 == 0)
        System.out.println(all.test(150));          // true

        String str1 = "abc";
        String str2 = "abc";
        Predicate<String> p2 = Predicate.isEqual(str1);
    }
}
