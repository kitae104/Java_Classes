package part2.stream.ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamArrayListTest {
  public static void main(String[] args) {
    List<Person> personList = new ArrayList<Person>();
    personList.add(new Person("박영수", 35));
    personList.add(new Person("김철", 25));
    personList.add(new Person("이영희", 30));
    personList.add(new Person("홍길동", 20));
    personList.add(new Person("강감찬", 50));
    personList.add(new Person("최민", 40));
    personList.add(new Person("이순신", 45));

    // 이름만 추출해서 출력하기
    personList.stream()
        .map(Person::getName) // Person 객체에서 이름만 추출 .map((person) -> person.getName())
        .forEach(System.out::println); // 출력 .forEach((name) -> System.out.println(name))
    System.out.println("---------------------");

    // 나이만 추출해서 출력하기
    personList.stream()
        .map(Person::getAge) // Person 객체에서 나이만 추출 .map((person) -> person.getAge())
        .forEach(System.out::println); // 출력 .forEach((age) -> System.out.println(age))
    System.out.println("---------------------");

    // 나이가 30 이상인 사람만 추출해서 출력하기
    personList.stream()
        .filter(person -> person.getAge() >= 30) // 나이가 30 이상인 사람만 추출
        //.map(Person::getName) // Person 객체에서 이름만 추출
        .forEach(System.out::println); // 출력
    System.out.println("---------------------");

    // 이름이 3글자 이상인 사람만 추출해서 출력하기
    personList.stream()
        .filter(person -> person.getName().length() >= 3) // 이름이 3글자 이상인 사람만 추출
        .forEach(System.out::println); // 출력
    System.out.println("---------------------");

    // 이름이 2글자 이하인 사람만 추출해서 출력하기
    personList.stream()
        .filter(person -> person.getName().length() <= 2) // 이름이 2글자 이하인 사람만 추출
        .forEach(System.out::println); // 출력
    System.out.println("---------------------");

    // 이름 순으로 정렬하여 출력
    personList.stream()
        .sorted((p1, p2) -> p1.getName().compareTo(p2.getName())) // 이름 순으로 정렬
        .forEach(System.out::println); // 출력
    System.out.println("---------------------");

    // 이름 역순으로 정렬하여 출력2
    personList.stream()
        .sorted(Comparator.comparing(Person::getName).reversed()) // 이름 역순으로 정렬
        .forEach(System.out::println); // 출력
    System.out.println("---------------------");

    // 나이 순으로 정렬하여 출력
    personList.stream()
        .sorted(Comparator.comparingInt(Person::getAge)) // 나이 순으로 정렬
        .forEach(System.out::println); // 출력
    System.out.println("---------------------");

    // 이름이 2글자인 사람들의 수
    long count = personList.stream()
        .filter(person -> person.getName().length() == 2) // 이름이 2글자인 사람만 추출
        .count(); // 개수 세기
    System.out.println("이름이 2글자인 사람의 수: " + count); // 출력


  }
}
