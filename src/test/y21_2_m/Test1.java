package test.y21_2_m;

public class Test1
{

	public static void main(String[] args)
	{
		Card card1 = new Card(3, true);
		Card card2 = new Card();
		System.out.println(card1.info());
		System.out.println(card2.info());
		
		Card[] cArr = new Card[2];
		cArr[0] = new Card(3,true);
		cArr[1] = new Card();
	}

}
