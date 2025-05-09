package part2.stream.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamReduce {
  public static void main(String[] args) {
    // 1부터 10까지의 합을 구하는 방법
    int sumResult = IntStream.rangeClosed(1, 10)
        .reduce(0, (a, b) -> a + b);
    System.out.println("1부터 10까지의 합: " + sumResult);

    // 1부터 10까지의 곱을 구하는 방법
    int product = IntStream.rangeClosed(1, 10)
        .reduce(1, (a, b) -> a * b);
    System.out.println("1부터 10까지의 곱: " + product);

    // 1부터 10까지의 홀수 값들의 합을 구하는 방법
    int oddSum = IntStream.rangeClosed(1, 10)
        .filter(n -> n % 2 != 0) // 홀수만 필터링
        .reduce(0, (a, b) -> a + b);
    System.out.println("1부터 10까지의 홀수 값들의 합: " + oddSum);

    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    int sumList = list.stream()
        .reduce(0, (sum, b) -> sum + b);
    System.out.println("ArrayList의 합: " + sumList);

    List<String> wordList = new ArrayList<>();
    wordList.add("AAA");
    wordList.add("BBB");
    wordList.add("CCC");
    wordList.add("DDD");

    String result = wordList.stream()
        .reduce("", (a, b) -> a + " " + b);
    System.out.println("String List의 합: " + result);
  }
}
