package override;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private String name;
    private int age;
    private String phone;
    private char gender;
    private double weight;
    private double height;
    private String role;



}
