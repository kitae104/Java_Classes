package lambda_stream.classes.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamEx2
{
	public static void main(String[] args)
	{
		List<People> peopleList = Arrays.asList(new People("홍길동", 17, 1), new People("홍길자", 18, 2),
				new People("홍길순", 15, 2), new People("홍길철", 17, 1));

		// foreach 사용하는 경우
		System.out.println("여성 목록 :");
		for (People people : peopleList)
		{
			if (people.getGender() == 2)
			{
				System.out.println(people);
			}
		}

		// stream filter 사용하기
		List<People> fList = peopleList.stream().filter(people -> people.getGender() == 2).collect(Collectors.toList());
		System.out.println("여성 목록 :");
		fList.forEach(System.out::println);

		// 나이순으로 정렬하기 OLD 버전
		List<People> ageList2 = new ArrayList<>(peopleList);
		Collections.sort(ageList2, new Comparator<People>() {
			@Override
			public int compare(People p1, People p2) {
				return Integer.compare(p1.getAge(), p2.getAge());
			}
		});

		System.out.println("나이순 목록2 :");
		for (People people : ageList2) {
			System.out.println(people);
		}

		// 나이순으로 정렬하기
		List<People> ageList = peopleList.stream().sorted(Comparator.comparing(People::getAge))
				.collect(Collectors.toList());
		System.out.println("나이순 목록 :");
		ageList.forEach(System.out::println);

		boolean allMatch = peopleList.stream()
				.allMatch(people -> people.getAge() > 12);
		System.out.println("나이가 모두 12보다 많은가?");
		System.out.println(allMatch);

		boolean anyMatch = peopleList.stream()
				.anyMatch(people -> people.getAge() > 19);
		System.out.println("나이가 모두 19보다 많은가?");
		System.out.println(anyMatch);

		boolean noneMatch = peopleList.stream()
				.noneMatch(people -> people.getAge() > 19);
		System.out.println("나이가 모두 19보다 많은 사람은 없는가?");
		System.out.println(anyMatch);

		Optional<People> maxPeople = peopleList.stream()
				.max(Comparator.comparing(People::getAge));
		System.out.println("나이가 제일 많은 사람은?");
		System.out.println(maxPeople.get());

		Optional<People> minPeople = peopleList.stream()
				.min(Comparator.comparing(People::getAge));
		System.out.println("나이가 제일 적은 사람은?");
		System.out.println(minPeople.get());

		// 특정한 필드로 그룹 만들기
		Map<Integer, List<People>> groupByGender = peopleList.stream()
				.collect(Collectors.groupingBy(People::getGender));
		System.out.println("남성 / 여성 목록");
		groupByGender.forEach((gender, pList) -> {
			System.out.println(gender);
			pList.forEach(System.out::println);
		});

		Optional<String> oldestWomanName = peopleList.stream()
				.filter(people -> people.getGender() == 2)
				.max(Comparator.comparing(People::getAge))
				.map(People::getName);
		System.out.println("여성들 중 가장 나이가 많은 사람의 이름은?");
		oldestWomanName.ifPresent(System.out::println);
	}
}
