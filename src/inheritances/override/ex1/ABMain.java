package inheritances.override.ex1;

public class ABMain
{

	public static void main(String[] args)
	{
		A a = new A();
		a.sort();		
		
		
		B b = new B();
		b.sort();
		b.test();
	}

}
