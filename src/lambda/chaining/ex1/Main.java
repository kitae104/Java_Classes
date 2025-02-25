package lambda.chaining.ex1;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {

    // Function 인터페이스는 입력을 받아서 출력을 반환하는 apply 메소드를 정의한다.
    String name = "Kitae";
    Function<String, String> uCase = String::toUpperCase;
    System.out.println(uCase.apply(name));

    // andThen 메소드는 두 개의 Function을 연결한다.
    Function<String, String > lastName = s -> s.concat(" Kim");
    Function<String, String> fullName = uCase.andThen(lastName);
    System.out.println(fullName.apply(name));

    // compose 메소드는 두 개의 Function을 연결한다.
    fullName = uCase.compose(lastName);
    System.out.println(fullName.apply(name));

    // 문자열을 받아서 대문자로 바꾸고 성을 추가하고 이름을 분리하는 Function을 생성한다.
    Function<String, String[]> f0 = uCase
        .andThen(s -> s.concat(" Kim"))
        .andThen(s -> s.split(" "));
    System.out.println(Arrays.toString(f0.apply(name)));

    // 문자열을 받아서 성과 이름을 바꾸고 성을 대문자로 바꾸는 Function을 생성한다.
    Function<String, String> f1 = uCase
        .andThen(s -> s.concat(" Kim"))
        .andThen(s -> s.split(" "))
        .andThen(s -> s[1].toUpperCase() + ", " + s[0]);
    System.out.println(f1.apply(name));

    // 문자열 길이를 반환하는 Function을 생성한다.
    Function<String, Integer> f2 = uCase
        .andThen(s -> s.concat(" Kim"))
        .andThen(s -> s.split(" "))
        .andThen(s -> String.join(", ", s))
        .andThen(String::length);
    System.out.println(f2.apply(name));

    String[] names = {"Ann", "Bob", "Carol"};
    Consumer<String> s0 = s -> System.out.print(s.charAt(0));
    Consumer<String> s1 = System.out::println;
    Arrays.asList(names).forEach(s0
        .andThen(s -> System.out.print(" - "))
        .andThen(s1));

    Predicate<String> p1 = s -> s.equals("KIM");
    Predicate<String> p2 = s -> s.equalsIgnoreCase("Kim");
    Predicate<String> p3 = s -> s.startsWith("K");
    Predicate<String> p4 = s -> s.endsWith("e");

    Predicate<String> combined1 = p1.or(p2);
    System.out.println("combinded1 = " + combined1.test(name));

    Predicate<String> combined2 = p3.and(p4);
    System.out.println("combinded2 = " + combined2.test(name));

    Predicate<String> combined3 = p3.and(p4).negate();
    System.out.println("combinded3 = " + combined3.test(name));
  }
}
