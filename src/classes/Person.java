package classes;

public class Person
{
	private Name name;
	private int age;
	private Address address;
	
	public Person(Name name, int age, Address address)
	{
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Name getName()
	{
		return name;
	}

	public void setName(Name name)
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

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	@Override
	public String toString()
	{
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
	
}
