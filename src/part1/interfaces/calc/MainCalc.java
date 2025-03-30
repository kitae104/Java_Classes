package part1.interfaces.calc;

import java.util.Scanner;

public class MainCalc {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("첫번째 숫자 입력 : ");
        int a = scanner.nextInt();

        System.out.print("첫번째 숫자 입력 : ");
        int b = scanner.nextInt();

        ICalc rc = new RealCalc();
        int result = rc.add(a, b);
        System.out.println();

        result = rc.add(a, b);
        System.out.println();

        result = rc.add(a, b);
        System.out.println();

        result = rc.add(a, b);
        System.out.println();

    }
}
