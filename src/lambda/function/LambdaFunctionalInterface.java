package lambda.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaFunctionalInterface {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0;
        Function<Integer, Integer> f = i -> i / 10 * 10;    // i의 일의 자리를 없앰

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);                        // 랜덤한 정수 10개를 리스트에 저장
        System.out.println(list);
        printEvenNum(p, c, list);                       // 짝수만 출력
        List<Integer> newList = doSomething(f, list);   // 10으로 나눈 나머지를 없앤 리스트
        System.out.println(newList);
    }

    private static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());

        for (T i : list) {
            newList.add(f.apply(i));    // 람다식을 수행
        }
        return newList;
    }

    private static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i)) {            // 짝수 인지 검사
                c.accept(i);            // 짝수면 소비 --> 출력
            }
        }
        System.out.println("]");
    }

    private static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());              // 람다식을  수행
        }
    }
}
