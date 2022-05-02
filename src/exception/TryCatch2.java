package exception;

public class TryCatch2
{
	public static void main(String arg[])
	{		
		try
		{
			divide();
			System.out.println("잘 나누어 집니다.");
		} 
		catch (ArithmeticException se)
		{
			System.out.println("예외 : " + se.getMessage());
		}
		System.out.println("계산이 성공적으로 끝났습니다.");
		//divide();
	}

	private static void divide()
	{
		int a = 0; 
		a = 10 / a;		
	}
}
