package jaemin.packages.stringbuffer;

import java.util.Random;

public class RandomEx {
    public static void main(String[] args) {

        System.out.println(Math.PI);

        Random random = new Random();
        int[] lotto = new int[6];

     for (int i = 0; i < 6; i++) {
            int i2 = random.nextInt(45) + 1;
            //System.out.println(i2);
            lotto[i] = i2;
            for (int j = 0; j < i; j++) {
                if(lotto[j] == i2) {
                    i--;
                    break;
                }
            }
        }
        System.out.println("===================================");
        for (int i = 0; i < lotto.length; i++) {
            System.out.println(lotto[i]);
        }
    }

}
