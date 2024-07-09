package casting.upcast;

public class Test
{

	public static void main(String[] args)
	{
		Person person = new Student();
		
		Student student = new Student();
		
		student = (Student) person;

	}

}
