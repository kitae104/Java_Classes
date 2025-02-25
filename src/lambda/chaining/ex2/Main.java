package lambda.chaining.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    record Person(String fristName, String lastName) {}

    List<Person> list = new ArrayList<>(Arrays.asList(
        new Person("Kitae", "Kim"),
        new Person("Amanda", "Lee"),
        new Person("Tim", "Cook"),
        new Person("Elon", "Musk")
    ));

    list.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));
    list.forEach(System.out::println);

    System.out.println("------------------------------------");
    list.sort(Comparator.comparing(Person::lastName));
    list.forEach(System.out::println);

    System.out.println("------------------------------------");
    list.sort(Comparator.comparing(Person::lastName)
            .thenComparing(Person::fristName).reversed());
    list.forEach(System.out::println);
  }
}
