package lambda.function;

public class MyFunctionTest
{

	public static void main(String[] args)
	{
		MyFunction f = new MyFunction()
		{
			
			@Override
			public int max(int a, int b)
			{
				return a > b ? a : b;
			}
		};
		
		int value = f.max(3, 5);
		System.out.println(value);

		// 중요! 함수형 인터페이스의 메서드와 람다식의 매개변수 개수와 반환타입이 일치해야 함
		MyFunction f2 = (a, b) -> a > b ? a : b;
		value = f2.max(3,  6);						// 실제로는 람다식이 호출됨
		System.out.println(value);

	}

}
