package collections.stream.basic;

import java.util.Arrays;
import java.util.List;

public class People
{
	private String name;
	private int age;
	private int gender;
	
	public People(String name, int age, int gender)
	{
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getGender()
	{
		return gender;
	}

	public void setGender(int gender)
	{
		this.gender = gender;
	}

	@Override
	public String toString()
	{
		return "People(name = " + name + ", age = " + age + ", gender = " + gender + ")";
	}
	
	public static List<People> getPeopleList(){
		return Arrays.asList(
			new People("홍길동", 17, 1),
			new People("홍길자", 18, 2),
			new People("홍길순", 15, 2),
			new People("홍길철", 17, 1)			
		);
	}
}
