package part2.lambda.ex4;

public class LambdaParameter {
	public static void main(String[] args) {
		// 최대 값을 구하는 람다식
		SmartCalc sc1 = (a, b) -> a > b ? a : b;
		
		// 범위에 대한 합계를 구하는 람다식
		SmartCalc sc2 = (a, b) -> {			
			int sum = 0;
			for (int i = a; i <= b; i++) {
				sum += i;
			}
			return sum;
		};
		
		int result1 = sc1.calc(10, 20);
		System.out.println("result1 = " + result1);
		int result2 = sc2.calc(1, 10);
		System.out.println("result2 = " + result2);
		
		// 메소드를 매개변수로 받는 메서드
		smartCalc(sc1, 100, 20);
		smartCalc(sc2, 1, 100);
	}
	
	// 메소드를 매개변수로 받는 메서드
	public static void smartCalc(SmartCalc sc, int a, int b) {
		int result = sc.calc(a, b);
		System.out.println("result = " + result);
	}
}
