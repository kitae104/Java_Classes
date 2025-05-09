package part2.stream.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LottoArrayList {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("몇 개를 구매 할건가요? ");
    int num = sc.nextInt();

    for (int i = 0; i < num; i++) {
      System.out.print("로또 번호 " + (i + 1) + ": ");
      ArrayList<Integer> lotto = new ArrayList<>();

      for (int j = 0; j < 6; j++) {
        int rand = (int) (Math.random() * 45) + 1; // 1~45

        // 중복 체크
        if (lotto.contains(rand)) {
          j--; // 중복된 번호가 나왔으므로 다시 뽑기
        } else {
          lotto.add(rand);
          }
      }

      // 정렬
      Collections.sort(lotto); // 정렬

      // 출력
      for (Integer n : lotto) {
        System.out.print(n + " ");
      }
      System.out.println();
    }
    sc.close();
  }
}
