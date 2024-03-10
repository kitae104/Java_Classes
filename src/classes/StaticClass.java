package classes;

public class StaticClass
{

	public static void main(String[] args)
	{
		int a = 10; 
		int b = 20;
		
		
		int result = add(a, b);
		
		System.out.println(result);

	}

	private static int add(int a, int b)
	{		
		return a + b;
	}

}
