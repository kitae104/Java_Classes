package test.y21_2_m;

public class Card
{
	private int num;
	private boolean checkRed;
	
	public Card() 
	{
		num = 1;
		checkRed = false;
	}
	
	public Card(int num, boolean checkRed)
	{
		this.num = num;
		this.checkRed = checkRed;
	}
	
	public String info()
	{
		if(checkRed) 
		{
			return num + "-Red";
		}
		else
		{
			return num + "-Black";
		}		 
	}
}
