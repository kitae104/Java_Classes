package part2.lambda.ex4;

@FunctionalInterface
public interface SuperFunc<T, U, V, R> {
	R apply(T t, U u, V v);	// 람다식으로 구현할 메서드 정의
}
