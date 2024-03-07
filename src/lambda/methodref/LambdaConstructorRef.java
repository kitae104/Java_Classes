package lambda.methodref;

import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaConstructorRef {
    public static void main(String[] args) {
//        Supplier<MyClass> s = () -> new MyClass();
        Supplier<MyClass> s = MyClass::new; // 생성자 메소드 참조
        MyClass mc = s.get();               // MyClass 반환
        System.out.println(mc);
        System.out.println(s.get());        // 새로운 MyClass 반환

//        Function<Integer, MyClass> f = (i) -> new MyClass(i);
        Function<Integer, MyClass> f = MyClass::new;
        MyClass mc2 = f.apply(100);
        System.out.println(mc2.getIv());
        System.out.println(f.apply(200).getIv());

        // 배열
        //Function<Integer, int[]> f2 = (i) -> new int[i];
        Function<Integer, int[]> f2 = int[]::new;
//        System.out.println(f2.apply(100).length);
        int[] arr = f2.apply(100);
        System.out.println("arr.length = " + arr.length);
    }
}
