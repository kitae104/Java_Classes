package part2.stream.ex1;

import java.util.Scanner;

public class LottoArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("몇 개를 구매 할건가요? ");
    int num = sc.nextInt();

    // 원하는 숫자 만큼 로또 번호를 저장할 배열 생성
    for (int i = 0; i < num; i++) {
      System.out.print("로또 번호 " + (i + 1) + ": ");
      int[] lotto = new int[6];

      // 로또 번호 생성 및 중복 체크
      for (int j = 0; j < lotto.length; j++) {
        int rand = (int) (Math.random() * 45) + 1; // 1~45
        lotto[j] = rand;

        // 중복 체크
        for (int k = 0; k < j; k++) {
          if (lotto[k] == rand) {
            j--; // 중복된 번호가 나왔으므로 다시 뽑기
            break;
          }
        }
      }

      // 선택 정렬(오름차순)
      for (int j = 0; j < lotto.length; j++) {
        for (int k = j+1; k < lotto.length; k++) {
          if (lotto[j] > lotto[k]) {
            int temp = lotto[j];
            lotto[j] = lotto[k];
            lotto[k] = temp;
          }
        }
      }

      // 출력
      for (int j = 0; j < lotto.length; j++) {
        System.out.print(lotto[j] + " ");
      }
      System.out.println();
    }

    sc.close();
  }
}
