package exception;

public class Method
{
	static void methodTest() throws Exception
	{
		try
		{
			throw new Exception();
		} 
		catch (Exception e)
		{
			System.out.println("methodTest  메서드  예외처리");
			throw e;
		}
	}

	public static void main(String[] args)
	{
		try
		{
			methodTest();
		} 
		catch (Exception e)
		{
			System.out.println("main  메서드  예외처리");
		}
	}
}
