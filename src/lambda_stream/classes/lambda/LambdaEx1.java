package lambda_stream.classes.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaEx1 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        list1.add("ddd");

        for (String s : list1) {
            System.out.println(s);
        }

        List<String> list2 = new ArrayList<>(List.of("aaa", "bbb", "ccc", "ddd"));    // Java 9부터 지원

        System.out.println("==================================");
        list2.forEach((s) -> System.out.println(s));    // forEach 사용

        System.out.println("==================================");
        list2.forEach(s -> System.out.println(s));    // 람다식 사용
    }
}
