package part2.lamdb.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LambdaEx1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		
		System.out.println(list);
		
		for (String str : list) {
			System.out.println(str);
		}
		
		List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		System.out.println(numbers);
		numbers.forEach(n -> System.out.println(n));  // 람다식으로 출력
		numbers.forEach(System.out::println);	// 메소드 레퍼런스(참조)
		numbers.stream().forEach(System.out::println); 
		numbers.stream().map(n -> n * 2).forEach(System.out::println);	// 스트림을 사용하여 각 요소를 2배로 변환하여 출력
		
		int[] arr = {1, 2, 3, 4, 5};
		// 배열을 람다식으로 출력
		IntStream.of(arr).map(n -> n * n).forEach(System.out::println);
		
		
		
		
	}
}
