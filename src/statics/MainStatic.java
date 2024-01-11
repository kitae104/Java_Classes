package statics;

public class MainStatic {
    public static void main(String[] args) {

        StaticClass.b = 200;
        StaticClass.printB();
        System.out.println(StaticClass.b);

//        StaticClass.MAX = 200; // 상수값 변경 불가

        StaticClass sc = new StaticClass();
        sc.printA();

        for (int i = 0; i < StaticClass.MAX; i++) {

        }
    }
}
