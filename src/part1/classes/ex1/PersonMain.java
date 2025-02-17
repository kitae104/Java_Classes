package part1.classes.ex1;

import part1.classes.ex2.Address;
import part1.classes.ex2.Name;
import part1.classes.ex2.Person;

public class PersonMain
{
	public static void main(String[] args)
	{
		Name name = new Name("홍", "길동");
		Address addr = new Address("인천시 미추홀구", "인하로 100");
		Person hong = new Person(name, 10, addr);
		System.out.println(hong);

		Name name1 = hong.getName();
		String firstName = name1.getFirstName();

		var name2 = hong.getName().getFirstName();
		System.out.println(name2);

		hong.getName().setFirstName("김");
		System.out.println(hong);
	}
}
