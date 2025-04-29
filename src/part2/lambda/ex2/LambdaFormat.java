package part2.lambda.ex2;

@FunctionalInterface
interface FuncInter1{
  // 매개변수 X, 반환 값 X 람다식 : 람다식 기본 형태
  void method();
}

@FunctionalInterface
interface FuncInter2{
  // 매개변수 O, 반환 값 X 람다식 : Consummer<T> 인터페이스 사용
  void method(String a, String b);
}

@FunctionalInterface
interface FuncInter3{
  // 매개변수 X, 반환 값 O 람다식 : Supplier<T> 인터페이스 사용
  String method();
}

@FunctionalInterface
interface FuncInter4{
  // 매개변수 X, 반환 값 O 람다식 : Supplier<T> 인터페이스 사용
  String method(String a, String b);
}

public class LambdaFormat {
  public static void main(String[] args) {
    // 매개변수 X, 반환 값 X 람다식 : 람다식 기본 형태
    FuncInter1 f1 = () -> { System.out.println("람다식 기본형태"); };
    f1.method();

    // 매개변수 O, 반환 값 X 람다식 : Consummer<T> 인터페이스 사용
    FuncInter2 f2 = (a, b) -> {
      String result = a + b;
      System.out.println(result);
    };
    f2.method("Hello", " World");

    // 매개변수 X, 반환 값 O 람다식 : Supplier<T> 인터페이스 사용
    FuncInter3 f3 = () -> {
      String a = "인하공전";
      String b = " 컴퓨터시스템공학과";
      return a + b;
    };
    String result2 = f3.method();
    System.out.println(result2);

    // 매개변수 O, 반환 값 O 람다식 : Function<T, R> 인터페이스 사용
    FuncInter4 f4 = (a, b) -> {
      String result = a + b;
      return result;
    };
    String result = f4.method("자바응용프로그래밍", " A반");
    System.out.println(result);



  }
}
