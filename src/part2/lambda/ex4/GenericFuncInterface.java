package part2.lambda.ex4;

public class GenericFuncInterface {
	public static void main(String[] args) {
		GenFunc<String> f1 = (s) -> System.out.println(s);
		f1.print("Hello");
		
		GenFunc<Integer> f2 = (i) -> System.out.println(i);
		f2.print(100);
		
		SuperFunc<Integer, Integer, Double, Double> sf = (a, b, c) -> (a + b) / c;
		
		double result = sf.apply(100,  90,  2.0);
		System.out.println(result);
		
	}
}
