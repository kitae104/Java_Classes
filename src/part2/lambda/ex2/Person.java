package part2.lambda.ex2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
  private String name;
  public Person(String name) {
    this.name = name;
  }
}
