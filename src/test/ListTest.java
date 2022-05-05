package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ListTest
{

	
	public static void main(String[] args)
	{
		
		Stack<String> stack = new Stack<>();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("영어", "English");
		String string = map.get("영어");
		
				
		List<Integer> list = new ArrayList<>();
		list.add(234);
		list.add(11);
		list.add(2);
		list.add(55);
		
		Collections.sort(list);
		Collections.reverse(list);
		
		for (int s : list)
		{
			System.out.println(s);
		}

	}

}
