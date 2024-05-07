package functional;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        printAllNumbersInListStructured(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {

        // How to loop the numbers?
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        numbers.stream().forEach(System.out::print);    // 메소드 참조
        System.out.println();

        numbers.stream().forEach(FP01Structured::print);    // 메소드 참조
        System.out.println();
        // 짝수인 경우만 출력하기
        numbers.stream().filter(number -> number %2 == 0).forEach(FP01Structured::print);    // 메소드 참조
    }

    private static void print(int number) {
        System.out.print(number + " ");
    }
}
