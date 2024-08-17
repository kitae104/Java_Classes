package jaemin.thread.ex1;

public class MainRace {
    public static void main(String[] args) {
        HorseRace h1 = new HorseRace("김재민");
        HorseRace h2 = new HorseRace("김지민");
        HorseRace h3 = new HorseRace("김기태");
        HorseRace h4 = new HorseRace("박승희");

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        Thread t3 = new Thread(h3);
        Thread t4 = new Thread(h4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("경주 시작");
    }
}
