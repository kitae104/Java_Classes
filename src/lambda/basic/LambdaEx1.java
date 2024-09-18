package lambda.basic;

public class LambdaEx1 {
    public static void main(String[] args) {
//        Object obj = (a, b) -> a > b ? a : b;     // 람다식은 Object 타입으로 변환되지 않음
        // 익명 객체 - Object는 함수형 인터페이스가 아니므로 람다식을 사용할 수 없음
        Object obj = new Object() {
            int max(int a, int b) {
                return a > b ? a : b;
            }
        };

//        int value = obj.max(3, 5);  // 함수형 인터페이스 필요!!
    }
}
