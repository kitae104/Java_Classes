package exception;

public class TryCatchFinally
{
	public static void main(String arg[])
	{		
		try
		{
			divide(5);
			System.out.println("잘 나누어 집니다.");
		} 
		catch (ArithmeticException se)
		{
			System.out.println("예외 : " + se.getMessage());
		}
		finally 
		{
			System.out.println("Try 블록이 수행되었습니다");
		}
	}

	private static void divide(int num)
	{
		int a = num; 
		a = 10 / a;		
	}
}
