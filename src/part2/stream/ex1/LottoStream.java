package part2.stream.ex1;

import java.util.*;

public class LottoStream {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("몇 개를 구매 할건가요? ");
    int num = sc.nextInt();

    for (int i = 0; i < num; i++) {
      System.out.print("로또 번호 " + (i + 1) + ": ");
      Set<Integer> lotto = new HashSet<>();

      while (lotto.size() < 6) {
        int rand = (int) (Math.random() * 45) + 1; // 1~45
        lotto.add(rand);
      }

      lotto.stream()
          .sorted() // 정렬
          .forEach(n -> System.out.print(n + " ")); // 출력
      System.out.println();
    }
    sc.close();
  }
}
