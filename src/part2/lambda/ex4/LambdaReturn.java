package part2.lambda.ex4;

// 람다식의 장점 
// 1. 메서드의 매개변수로 람다식을 전달할 수 있다.
// 2. 메서드의 반환값으로 람다식을 반환할 수 있다.
// 3. 함수를 쉽게 축약해서 정의 할 수 있다.
public class LambdaReturn {
	public static void main(String[] args) {
		PrintString ps1 = returnLambda(1);	// 람다식 1
		PrintString ps2 = returnLambda(2);	// 람다식 2
		PrintString ps3 = returnLambda(3);	// 람다식 3
		
		ps1.showString("AAA");	// 람다식 1 호출
		ps2.showString("BBB");	// 람다식 2 호출
		ps3.showString("CCC");	// 람다식 3 호출
	}
	
	// 람다식을 반환하는 메서드
	private static PrintString returnLambda(int code) {
		switch(code) {
			case 1:
				// 람다식으로 구현
				return msg -> System.out.println("메시지1 : " + msg);
			case 2:
				return msg -> {
					System.out.println("메시지2 : " + msg);
					System.out.println("메시지 길이 : " + msg.length());
				};
			case 3:
				return msg -> System.out.println(msg);
			default:
				return (msg) -> System.out.println();
		}
	}
}
