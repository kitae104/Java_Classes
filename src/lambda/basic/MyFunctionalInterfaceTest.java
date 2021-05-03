package lambda.basic;

public class MyFunctionalInterfaceTest {

	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		// 일반적인 형태 
		fi = (x, y) -> {
			int result = x + y;
			return result;
		};
		System.out.println(fi.method(3, 4));
		
		// 축약 1 (연산을 직접 리턴하는 경우)
		fi = (x, y) -> { return x + y;};
		System.out.println(fi.method(3, 4));
		
		// 축약 2 (리턴문 하나만 있는 경우)
		fi = (x, y) -> x + y;
		System.out.println(fi.method(3, 4));

		// 축약 3 (함수를 호출하는 경우)
		fi = (x, y) -> {return sum(x, y); };
		System.out.println(fi.method(3, 4));
		
		// 축약 4
		fi = (x, y) -> sum(x, y); 
		System.out.println(fi.method(3, 4));
		
	}

	public static int sum(int x, int y) {
		return (x + y);
	}
}
