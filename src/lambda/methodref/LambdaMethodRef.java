package lambda.methodref;

import java.util.function.Function;

public class LambdaMethodRef {
    public static void main(String[] args) {
        //Function<String, Integer> f = (String s) -> Integer.parseInt(s);
        Function<String, Integer> f = Integer::parseInt;    // 메소드 참조
        System.out.println(f.apply("100") + 200);       // 숫자로 변경된것 확인!
    }
}
