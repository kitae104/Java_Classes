package jaemin.thread.ex1;

import java.util.Random;

public class HorseRace implements Runnable {
    Random random = new Random();
    private String name;

    public HorseRace(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(name + "의" + i * 10 + "미터 전진");

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + "이 골인");
    }
}
