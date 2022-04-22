package exception;

public class TryCatch
{
	public static void main(String arg[])
	{
		int a;
		try
		{
			a = 0;
			a = 10 / a;
			System.out.println("잘 나누어 집니다.");
		} 
		catch (ArithmeticException se)
		{
			System.out.println("예외 : " + se.getMessage());
		}
		System.out.println("계산이 성공적으로 끝났습니다.");
	}
}
