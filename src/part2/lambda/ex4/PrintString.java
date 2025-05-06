package part2.lambda.ex4;

@FunctionalInterface
public interface PrintString {
	// 람다식으로 구현할 메서드 정의
	void showString(String msg);	// 매개변수로 String을 받는 메서드
}
