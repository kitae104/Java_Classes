package inheritances.override;

public class MainPerson {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);


        Person p = Person.builder()
                .name("김재민")
                .age(20)
                .phone("111-2222")
                .role("막내딸")
                .build();

        System.out.println(p);
    }
}
