package part2.lamdb.ex1;

// 함수형 인터페이스 정의
@FunctionalInterface
public interface MyFunction {
	int myMax(int a, int b);	// 람다식으로 구현할 메서드 정의
}
