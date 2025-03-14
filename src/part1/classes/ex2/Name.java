package part1.classes.ex2;

public class Name
{
	private String firstName;		// 성 
	private String lastName; 		// 이름
	
	
	public Name(String firstName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public String getFirstName()
	{
		return firstName;
	}


	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}


	public String getLastName()
	{
		return lastName;
	}


	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}


	@Override
	public String toString()
	{
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
