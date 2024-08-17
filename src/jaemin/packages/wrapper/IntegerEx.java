package jaemin.packages.wrapper;

public class IntegerEx {
    public static void main(String[] args) {
        // 235 이진수 값?
        System.out.println(Integer.toBinaryString(235));
        System.out.println(Integer.toHexString(235));

        String str1 = "123";
        int value1 = 123;
        int value2 = Integer.parseInt(str1) + value1;

        Integer i = Integer.valueOf(10);
        Integer i2 = 10;  // auto boxing

        System.out.println(i == i2); // true

        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = new String("Java");
        String s5 = s4;

        if(s4 == s5) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }

    }
}
