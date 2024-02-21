package lambda.part2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaEx1 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("홍", "길동"),
                new Person("손", "흥민"),
                new Person("박", "철순"),
                new Person("홍", "명보")
        ));

        var comparatorLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        };

        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        System.out.println(people);

        // 람다 형태 사용
        people.sort((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        System.out.println(people);

        // 람다 형태 사용2
        people.sort(Comparator.comparing(Person::getLastName));
        System.out.println(people);
    }
}
