package test.y21_2_m;

public class Test2
{

	public static void main(String[] args)
	{
		int sum = 0;
		for (int i = 0; i < 13; i++)
		{
			if(i%3==0)
				continue;
			sum += i;
		}
		System.out.println("sum = " + sum);
		
		int total = 0, x = 0, y;
		while(++x < 5) {
			y = x * x;			
			total += y;
		}
		System.out.println("총합 : " + total);
		
		int[] arr = new int[3];
		
		int[][] arr2 = new int[3][];
		
		
		int arr4[] = new int[] {1,2,3,4,5};
		
		int[][] test = {
				{5,5,5,5,5},
				{10,10,10},
				{20,20,20,20},
				{30,30}
		};
		
		System.out.println(test.length);
		System.out.println(test[3].length);
		
		
		
	}

}
