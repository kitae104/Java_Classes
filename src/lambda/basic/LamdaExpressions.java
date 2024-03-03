package lambda.basic;

import java.util.ArrayList;
import java.util.List;

public class LamdaExpressions
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>(List.of("aaa", "bbb", "ccc", "ddd"));
		
		for (String s : list)
		{
			System.out.println(s);
		}
		
		System.out.println("==================================");
		list.forEach((s) -> System.out.println(s));
		
		System.out.println("==================================");
		list.forEach(s -> System.out.println(s));
	}
}
