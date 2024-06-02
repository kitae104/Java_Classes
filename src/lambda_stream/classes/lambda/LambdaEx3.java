package lambda_stream.classes.lambda;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LambdaEx3
{
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++)
		{
			list.add(i);
		}
		System.out.println(list);

		// 리스트의 모든 요소 출력하기
		list.forEach((i) -> System.out.print(i + ", ")); 
		System.out.println();
		
		// 리스트에서 2 또는 3의 배수를 제거하기
		list.removeIf(x -> x %2 == 0 || x % 3 == 0);
		System.out.println(list);
		
		// 리스트의 각 요소에 10을 곱하기
        list.replaceAll(i -> i * 10);            
        System.out.println(list);
        
        // 맵 처리하기 
        Map<String, String> map = new HashMap<>();
        map.put("apple", "사과");
        map.put("music", "음악");
        map.put("computer", "컴퓨터");
        map.put("banana", "바나나");

        map.forEach((k, v) -> System.out.print("{" + k + "," + v + "}, "));
        System.out.println();
        
        System.out.println(map.get("apple"));
	}
}
