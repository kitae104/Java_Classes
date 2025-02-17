package part1.classes.ex3;
// instance의 경우와 달리 static 메소드는 객체 생성 없이 사용 가능하다.
public class StaticClass {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int result = add(a, b);

        System.out.println(result);
        System.out.println(Math.max(10, 2));
        System.out.println(Math.PI);
    }

    private static int add(int a, int b) {
        return a + b;
    }
}
