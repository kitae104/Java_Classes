package part2.lamdb.ex2;

import java.util.function.Function;

// 메소드 참조 :  :: 기호를 사용하여 람다식을 더욱 간결하게 표현하는 기법
public class MethodRef1 {
  public static void main(String[] args) {

    // 기본 람다식
    Function<String, Integer> lambda = (str) -> { return Integer.parseInt(str); };
    int result = lambda.apply( "100" );
    System.out.println( result ); // 100   (int)

    // 메소드 참조
    Function<String, Integer> methodRef = Integer::parseInt;
    int result2 = methodRef .apply( "200" );
    System.out.println( result2 ); // 200   (int)
  }
}
