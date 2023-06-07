package jaemin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(101);
        Subway subway = new Subway(2);
        Taxi taxi = new Taxi(5757);
        System.out.println();

        System.out.println("101번 버스 비용 : 1000");
        System.out.println("2번 지하철 비용 : 1500");
        System.out.println("5757번 택시 비용 : 미정");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("사람의 이름을 입력하세요 : ");
        String name = scanner.nextLine();
        System.out.print("얼마가 있나요? : ");
        int money = scanner.nextInt();

        System.out.println("승객 " + name + " 은" + money + "원의 돈을 갖고 있습니다.");

        Person person = new Person(name, money);

        person.takeRide(bus);
        bus.showInfo();
        System.out.println();

        person.takeRide(bus);
        bus.showInfo();
        System.out.println();

        person.takeRide(bus);
        bus.showInfo();
        System.out.println();

        person.takeRide(bus);
        bus.showInfo();
        System.out.println();

        person.takeRide(taxi,35);
        taxi.showInfo();
        System.out.println();

        person.takeRide(subway);
        subway.showInfo();
        System.out.println();

    }
}