package packages;

public class WrapperClass {
    public static void main(String[] args) {
        Integer i = Integer.valueOf(10);
        Integer j = 10;    // Auto Boxing
        int k = 10;

        System.out.println(j.intValue());
        System.out.println(j);  // Auto Unboxing

        int i1 = Integer.parseInt("1234");
        int i2 = Integer.parseInt("1234");
        System.out.println(i1 + i2);

        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toHexString(15));
    }
}
