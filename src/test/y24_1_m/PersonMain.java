package test.y24_1_m;

public class PersonMain {
    public static void main(String[] args) {

        Name name = new Name();
        name.setFirstName("홍");
        name.setLastName("길동");

        Address addr = new Address("인천 미추홀구", "인하로 100");

        Person hong = new Person(name, 20, addr);
        System.out.println(hong);

        Name name2 = new Name();
        name2.setFirstName("한");
        name2.setLastName("석봉");

        Address addr2 = new Address("인천 미추홀구", "인하로 100");

        Person han = new Person(name2, 30, addr2);
        System.out.println(han);

    }
}
