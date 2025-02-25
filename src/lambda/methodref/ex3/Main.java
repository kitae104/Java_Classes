package lambda.methodref.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {

  private static Random random = new Random();    // Random 객체 생성

  private record Person(String first){
    public String last(String s){
      return first + " " + s.substring(0, s.indexOf(" "));
    }
  }

  public static void main(String[] args) {
    String[] names = {"Brad", "Kate", "Kim", "Jack", "Joe", "Tom"};

    Person tim = new Person("Tim");

    // UnaryOperator<String> 리스트 생성
    List<UnaryOperator<String>> list = new ArrayList<>(List.of(
        String::toUpperCase,
        String::toLowerCase,
        s -> s + " " + getRandomChar('D', 'M') + ".",
        s -> s + " " + reverse(s, 0, s.indexOf(" ")),
        Main::reverse,
        String::new,
        s -> new String(s),
        String::valueOf,
        tim::last,
        (new Person("KIM"))::last
    ));

    applyChanges(names, list);
  }

  // applyChanges 메소드는 names 배열과 UnaryOperator<String> 리스트를 받아서 names 배열의 모든 요소에 UnaryOperator<String> 리스트에 있는 함수를 적용한다.
  private static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunction){
    List<String> backedByArray = Arrays.asList(names);
    for(var function: stringFunction){
      backedByArray.replaceAll((s) -> s.transform(function));
      System.out.println(Arrays.toString(names));
    }
  }

  // getRandomChar 메소드는 startChar와 endChar 사이의 랜덤한 문자를 반환한다.
  private static char getRandomChar(char startChar, char endChar) {
    return (char) random.nextInt((int) startChar, (int) endChar + 1);
  }

  //  reverse 메소드는 s 문자열을 뒤집어서 반환한다.
  private static String reverse(String s) {
    return reverse(s, 0, s.length());
  }

  //  reverse 메소드는 s 문자열의 start부터 end까지의 문자열을 뒤집어서 반환한다.
  private static String reverse(String s, int start, int end) {
    return new StringBuilder(s.substring(start, end)).reverse().toString();
  }
}
