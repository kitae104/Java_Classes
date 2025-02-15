package lambda.methodref.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

// 메소드 참조(Method Reference)는 람다식을 더 간결하게 표현하는 방법이다.
class PlainOld {
    private static int last_id = 1;
    private int id;

    public PlainOld() {
        this.id = PlainOld.last_id++;
        System.out.println("PlainOld 객체 생성: " + this.id);
    }
}
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Anna", "Bob", "Chuck", "Dave"));
        list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println); // 메소드 참조로 더 간결하게 표현

        calculator((a, b) -> a + b, 3, 4);
        calculator(Integer::sum, 3, 4); // 메소드 참조로 더 간결하게 표현
        calculator(Double::sum, 3.5, 4.2);

        Supplier<PlainOld> ref1 = () -> new PlainOld();
        PlainOld obj1 = ref1.get();

        Supplier<PlainOld> ref2 = PlainOld::new; // 메소드 참조로 더 간결하게 표현
        PlainOld obj2 = ref2.get();

        System.out.println("Getting array");
        PlainOld[] pojoArray = seedArray(PlainOld::new, 10);
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}
