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
        Consumer<Integer> c = i -> System.out.println(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0;
        Function<Integer, Integer> f = i -> i / 10 * 10;    // i의 일의 자리를 없앰

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);
        printEvenNum(p, c, list);
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    private static List<Integer> doSomething(Function<Integer, Integer> f, List<Integer> list) {
    }

    private static void printEvenNum(Predicate<Integer> p, Consumer<Integer> c, List<Integer> list) {
    }

    private static void makeRandomList(Supplier<Integer> s, List<Integer> list) {
    }
}
