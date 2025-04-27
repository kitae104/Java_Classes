package part2.lamdb.ex2;

import java.util.function.Function;

// 객체를 생성하여 반환하는 람다식 대신 클래스::new 형태로 생성자를 참조하는 방법
public class ConstructorRef1 {
  public static void main(String[] args) {

    // 기본 람다식
    // Function<String, Person> lambda = (name) -> { return new Person("kitae"); };
    Function<String, Person> lambda = (name) -> new Person(name);
    Person p1 = lambda.apply("kitae");          // 람다식을 통한 객체 생성
    System.out.println( p1.getName() );

    // 생성자 참조
    Function<String, Person> constructorRef = Person::new;
    Person p2 = constructorRef.apply("kitae");   // 생성자 참조를 통한 객체 생성
    System.out.println( p2.getName() );
  }
}
