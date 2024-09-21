package lambda.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
// 함수형 인터페이스(Functional Interface) : 추상 메서드가 하나만 있는 인터페이스
// 자주 사용되는 함수형 인터페이스 제공 : java.util.function 패키지
public class LambdaFunctionalInterface {
    public static void main(String[] args) {
        // Supplier(공급자) : 입력이 없고 반환만 있는 경우
        // Supplier<T> : T get()
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;    // 1~100사이의 랜덤한 정수

        // Consumer(소비자) : 매개변수만 있고 반환 값이 없는 경우
        // Consumer<T> : void accept(T t)
        Consumer<Integer> c = i -> System.out.print(i + ", ");  // 출력만 수행

        // Function(함수) : 매개변수와 반환 값이 모두 있는 경우(가장 일반적)
        // Function<T, R> : R apply(T t)
        Function<Integer, Integer> f = i -> i / 10 * 10;    // i의 일의 자리를 없앰

        // Predicate(프레디케이트) : 매개변수가 있고 boolean을 반환하는 경우(조건식을 표현)
        // Predicate<T> : boolean test(T t)
        Predicate<Integer> p = i -> i % 2 == 0;   // 짝수인지 검사

        // ex1> Predicate=======================================================
        Predicate<String> isEmptyStr = str -> str.length() == 0;
        String testStr = "";
        if(isEmptyStr.test(testStr)) {
            System.out.println("This string is empty.");
        } else {
            System.out.println("This string is not empty.");
        }
        //========================================================================

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);                        // 랜덤한 정수 10개를 리스트에 저장
        System.out.println(list);
        printEvenNum(p, c, list);                       // 짝수만 출력
        List<Integer> newList = doSomething(f, list);   // 10으로 나눈 나머지를 없앤 리스트
        System.out.println(newList);
    }

    private static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());              // 람다식을  수행 - 이름을 저 함수로 대체해서 처리
        }
    }

    private static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i)) {            // 짝수 인지 검사 : Predicate<Integer> p = i -> i % 2 == 0;
                c.accept(i);            // 짝수면 소비 --> 출력 : Consumer<Integer> c = i -> System.out.print(i + ", ");
            }
        }
        System.out.println("]");
    }

    private static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());

        for (T i : list) {
            newList.add(f.apply(i));    // 람다식을 수행 : Function<Integer, Integer> f = i -> i / 10 * 10;
        }
        return newList;
    }
}
