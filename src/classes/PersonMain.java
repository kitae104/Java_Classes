package classes;

public class PersonMain
{
	public static void main(String[] args)
	{
		Name name = new Name("홍", "길동");
		Address addr = new Address("인천시 미추홀구", "인하로 100");
		Person hong = new Person(name, 10, addr);
		System.out.println(hong);
		
		var name2 = hong.getName().getFirstName();
		System.out.println(name2);
	}
}
