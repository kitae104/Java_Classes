package lambda.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LambdaCollection {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // 리스트의 모든 요소 출력하기
        list.forEach((i) -> System.out.print(i + ", "));    // consumer의 accept()를 호출
        System.out.println();

        // 리스트에서 2 또는 3의 배수를 제거하기
        list.removeIf(x -> x % 2 == 0 || x % 3 == 0);       // predicate의 test()를 호출
        System.out.println(list);

        // 리스트의 각 요소에 10을 곱하기
        list.replaceAll(i -> i * 10);            // unaryOperator의 apply()를 호출
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        map.forEach((k, v) -> System.out.print("{" + k + "," + v + "}, "));    // consumer의 accept()를 호출
    }
}
