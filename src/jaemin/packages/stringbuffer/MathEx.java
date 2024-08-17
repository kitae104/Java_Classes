package jaemin.packages.stringbuffer;

public class MathEx {
    public static void main(String[] args) {

        int[] diceCount = new int[6];
        for (int i = 0; i <100 ; i++) {
            int d = (int)(Math.random() * 6) + 1;
            System.out.println(d);

        }
    }
}
