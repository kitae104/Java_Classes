package lambda.andthen_compose;

import java.util.function.Consumer;

public class ConsumerAndThenEx {

	public static void main(String[] args) {
		
		Consumer<Member> consumerA = (m) -> {
			System.out.println("consumerA: " + m.getName());
		};
		
		Consumer<Member> consumerB = (m) -> {
			System.out.println("consumerB: " + m.getId());
		};
		
		// Consumer에서 andThen은 단순히 실행 순서만 결정한다. 
		Consumer<Member> consumberAB = consumerA.andThen(consumerB);
		
		consumberAB.accept(new Member("홍길동", "hong", null));
	}

}
