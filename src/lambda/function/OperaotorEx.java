package lambda.function;

import java.util.function.IntBinaryOperator;

public class OperaotorEx {

	private static int[] scores = {92, 95, 87};
	
	public static int maxOrMin(IntBinaryOperator operator) {
		
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// 최대값 
		int max = maxOrMin((a,b) -> {
			if(a>=b) {
				return a;
			} else {
				return b;
			}
		});
		
		System.out.println("최대값 " + max);

		// 최소값 
		int min = maxOrMin((a, b) ->{
			if(a <= b) {
				return a;
			} else {
				return b;
			}
		});
		
		System.out.println("최소값 " + min);
		
	}

}
