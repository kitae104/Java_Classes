package packages;

public class Lotto {
    public static void main(String[] args) {
        int[] lotto = new int[6];
        for (int i = 0; i < lotto.length ; i++) {
            int num = (int)(Math.random() * 45) + 1;
            System.out.println(num);
            lotto[i] = num;
        }

        for (int i = 0; i < lotto.length; i++) {
            System.out.print(lotto[i] + " ");
        }
    }
}
