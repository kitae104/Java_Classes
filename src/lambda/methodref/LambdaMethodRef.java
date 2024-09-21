package lambda.methodref;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

// 메소드 참조 : 람다식을 더 간결하게 사용하는 방법
public class LambdaMethodRef {
    public static void main(String[] args) {

        //==========================================================================================
        // static 메소드 참조 --> 입력, 출력 타입을 통해 타입이나 매개 변수에 대한 정보를 알 수 있음
        //==========================================================================================
        //Function<String, Integer> f = (String s) -> Integer.parseInt(s);
        Function<String, Integer> f = Integer::parseInt;    // 메소드 참조
        System.out.println(f.apply("100") + 200);       // 숫자로 변경된것 확인!

        //BiFunction<String, String, Boolean> f2 = (s1, s2) -> s1.equals(s2);
        BiFunction<String, String, Boolean> f2 = String::equals;
        System.out.println(f2.apply("abc", "abc"));      // true

        //==========================================================================================
        // 생성자 메소드 참조 --> 클래스 이름::new
        //==========================================================================================
        // Supplier는 매개변수가 없고 리턴값이 있는 경우 -> MyClass 객체 생성하여 반환
        // Supplier<MyClass> s = () -> new MyClass();
        Supplier<MyClass> s = MyClass::new; // 생성자 메소드 참조
        MyClass mc = s.get();               // MyClass 반환
        System.out.println(mc);
        System.out.println(s.get());        // 새로운 MyClass 반환

        // Function은 매개변수가 있고 리턴값이 있는 경우 -> MyClass 객체 생성하여 반환
        // Function<Integer, MyClass> f3 = (i) -> new MyClass(i);
        Function<Integer, MyClass> f3 = MyClass::new; // 생성자 메소드 참조(역으로 만들어 보면 확실하게 이해가능!!)
        MyClass mc2 = f3.apply(100);
        System.out.println(mc2);
        System.out.println(mc2.getIv());
        System.out.println(f3.apply(200).getIv());

        //==========================================================================================
        // 배열 - 배열의 길이를 입력받아 배열을 생성 (입력값이 있고 리턴값이 있는 경우 - Function)
        //==========================================================================================
        //Function<Integer, int[]> f4 = (i) -> new int[i];
        Function<Integer, int[]> f4 = int[]::new;   // 많이 사용되는 형태
//        System.out.println(f2.apply(100).length);
        int[] arr = f4.apply(100);
        System.out.println("arr.length = " + arr.length);
    }
}
