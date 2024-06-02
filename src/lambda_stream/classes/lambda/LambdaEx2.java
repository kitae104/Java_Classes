package lambda_stream.classes.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaEx2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("ccc", "bbb", "aaa", "ddd");
        List<Integer> list2 = Arrays.asList(222, 111, 444, 333);

        // 기존의 방식 (익명 내부 클래스)
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println(list);

        // 람다식(함수형 인터페이스 사용)
        Collections.sort(list2, (s1, s2) -> s2.compareTo(s1));
        System.out.println(list2);

    }
}
