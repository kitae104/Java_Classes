package lambda.param;

public class LambdaParam {

    static void execute(MyFunction f) {
        f.run();            // 람다식을 받아 실행
    }

    static MyFunction getMyFunction() {
        MyFunction f = () -> System.out.println("f3.run()");
        return f;                                               // 람다식을 반환
    }
    public static void main(String[] args) {
        MyFunction f1 = () -> System.out.println("f1.run()");   // 람다식

        MyFunction f2 = new MyFunction() {
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();                // 람다식을 반환받아 실행

        f1.run();                                       // 람다식 실행
        f2.run();
        f3.run();

        execute(f1);                                    // 람다식을 매개변수로 전달
        execute(() -> System.out.println("run()"));
    }
}
