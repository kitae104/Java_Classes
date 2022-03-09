package collections.stream.basic;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStream
{

	public static void main(String[] args)
	{
		// foreach 사용하는 경우 
		System.out.println("여성 목록 :");
		for (People people : People.getPeopleList())
		{
			if(people.getGender() == 2) 
			{
				System.out.println(people);
			}
		}

		// stream filter 사용하기 
		List<People> fList = People.getPeopleList().stream()
				.filter(people -> people.getGender() == 2)
				.collect(Collectors.toList());
		System.out.println("여성 목록 :");
		fList.forEach(System.out::println);
		
		// 나이순으로 정렬하기 
		List<People> sList = People.getPeopleList().stream()
				.sorted(Comparator.comparing(People::getAge))
				.collect(Collectors.toList());
		System.out.println("나이순 목록 :");
		sList.forEach(System.out::println);
		
		boolean allMatch = People.getPeopleList().stream()
				.allMatch(people -> people.getAge() > 12);
		System.out.println("나이가 모두 12보다 많은가?");
		System.out.println(allMatch);
		
		boolean anyMatch = People.getPeopleList().stream()
				.anyMatch(people -> people.getAge() > 19);
		System.out.println("나이가 모두 19보다 많은가?");
		System.out.println(anyMatch);
		
		boolean noneMatch = People.getPeopleList().stream()
				.noneMatch(people -> people.getAge() > 19);
		System.out.println("나이가 모두 19보다 많은 사람은 없는가?");
		System.out.println(anyMatch);
		
		Optional<People> maxPeople = People.getPeopleList().stream()
				.max(Comparator.comparing(People::getAge));
		System.out.println("나이가 제일 많은 사람은?");
		System.out.println(maxPeople.get());

		Optional<People> minPeople = People.getPeopleList().stream()
				.min(Comparator.comparing(People::getAge));
		System.out.println("나이가 제일 적은 사람은?");
		System.out.println(minPeople.get());
		
		// 특정한 필드로 그룹 만들기 
		Map<Integer, List<People>> groupByGender = People.getPeopleList().stream()
				.collect(Collectors.groupingBy(People::getGender));
		System.out.println("남성 / 여성 목록");
		groupByGender.forEach((gender, peopleList) -> {
			System.out.println(gender);
			peopleList.forEach(System.out::println);
		});
		
		Optional<String> oldestWomanName = People.getPeopleList().stream()
				.filter(people -> people.getGender() == 2)
				.max(Comparator.comparing(People::getAge))
				.map(People::getName);
		System.out.println("여성들 중 가장 나이가 많은 사람의 이름은?");
		oldestWomanName.ifPresent(System.out::println);
		
	}

}
