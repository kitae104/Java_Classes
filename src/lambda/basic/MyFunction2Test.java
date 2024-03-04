package lambda.basic;

public class MyFunction2Test {
    public static void main(String[] args) {
        MyFunction2 mf2 = new MyFunction2() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        int value = mf2.max(10, 30);
        System.out.println("value = " + value);

        // 간단히 람다식으로 변경
        MyFunction2 f2 = (a, b) -> a > b ? a : b;
        int value2 = f2.max(6, 2);
        System.out.println("value2 = " + value2);

    }
}
