package collections.stream.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMake
{

	public static void main(String[] args)
	{
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		//스트림 만들기 
		Stream<Integer> intStream = list.stream();
		Stream<String> strStream = Stream.of(new String[] {"a", "b", "c"});
		Stream<Integer> evenStream = Stream.iterate(0, n -> n+2);
		Stream<Double> randomStream = Stream.generate(Math::random);
		IntStream intStream1 = new Random().ints(5);
		
		// 연산하기 1
		evenStream.distinct().limit(5).sorted().forEach(System.out::println);
		
		// 연산하기 2
		String[] strArr = {"dd", "aaa", "CC", "cc", "b"};
		Stream<String> stream = Stream.of(strArr);
		//Stream<String> sortedStream = stream.sorted();
		
		// 스트림은 읽기만 할 뿐 변경하지 않음
		List<Integer> list2 = Arrays.asList(3, 1, 5, 4, 2);
		List<Integer> sortedList = list2.stream().sorted().collect(Collectors.toList());
		System.out.println(list2);
		System.out.println(sortedList);
		
		// 일회용 (다시 스트림 생성해야함)
		stream.forEach(System.out::println);
		//int numOfStr= (int) stream.count();
		
		// 최종 연산 전까지 중간연산이 수행되지 않는다.
		IntStream intStream2 = new Random().ints(1, 46);
		intStream2.distinct().limit(6).sorted().forEach(i -> System.out.print(i + ", "));
		
		// 스트림의 작업을 병렬로 처리
		
		// 기본형 스트림 - IntStream, LongStream, DoubleStream
	}
}
