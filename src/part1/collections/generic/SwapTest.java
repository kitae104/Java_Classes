package part1.collections.generic;

public class SwapTest
{

	public static void main(String[] args)
	{	
		String a = "A";
		String b = "B";
		swap(a, b);
		
		int a1 = 1; 
		int b1 = 2;
		swap(a1, b1);

	}

	static private<T> void swap(T a, T b)
	{
		T temp = a;
		a = b;
		b = temp;			
	}

	

}
