package collections.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
public class ArrayListTest
{

	public static void main(String[] args)
	{
		String[] sArr = new String[2];
		sArr[0] = new String("김기태");
		sArr[1] = new String("김재민");
		//sArr[2] = new String("박승희");	// 런타임 예외
		
		Vector<String> sVector = new Vector<>();
		sVector.add("김기태");
		sVector.add("김재민");
		sVector.add("박승희");	// 컴파일 타임 에러 
		sVector.insertElementAt("김지민", 1);
		sVector.remove(0);
		
		
		for (int i = 0; i < sVector.size(); i++)
		{
			System.out.println(sVector.get(i));
		}
		
		System.out.println("===================================");
		
		
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("김기태");
		arrayList.add("김재민");
		arrayList.add("박승희");
		
		for (String s : arrayList)
		{
			System.out.println(s);
		}
		
		System.out.println("===================================");
		
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("김기태"); 
		linkedList.add("김재민"); 
		linkedList.add("박승희"); 
		
		linkedList.stream().forEach(s -> System.out.println(s));

	}

}
