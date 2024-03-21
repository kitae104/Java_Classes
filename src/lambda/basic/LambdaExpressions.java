package lambda.basic;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressions
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>(List.of("aaa", "bbb", "ccc", "ddd"));	// Java 9부터 지원

		for (String s : list)
		{
			System.out.println(s);
		}
		
		System.out.println("==================================");
		list.forEach((s) -> System.out.println(s));	// forEach 사용
		
		System.out.println("==================================");
		list.forEach(s -> System.out.println(s)); 	// 람다식 사용
	}
}
