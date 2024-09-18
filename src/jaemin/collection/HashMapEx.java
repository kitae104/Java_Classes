package jaemin.collection;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        HashMap<String, Person> addressBook = new HashMap<>();
        Person p1 = new Person("김기태", 52, "인천 구월동");
        Person p2 = new Person();
        p2.setName("박승희");
        p2.setAge(48);
        p2.setAddress("인천 구월동");
        Person p3 = Person.builder()
                .name("김지민")
                .age(22)
                .address("서울 종로구")
                .build();
        Person p4 = Person.builder()
                .age(20)
                .address("서울 성동구")
                .name("김재민")
                .build();

        addressBook.put("a", p1);
        addressBook.put("b", p2);
        addressBook.put("c", p3);
        addressBook.put("d", p4);

        System.out.println(addressBook);

        Set<String> keySets = addressBook.keySet();
        Iterator<String> iter = keySets.iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            Person person = addressBook.get(key);
            System.out.println(person.getName());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 이름(종료 exit): ");
        String name = sc.next();
        int age = addressBook.get(name).getAge();
        System.out.println(name + "의 나이는 " + age + "세 입니다.");
    }
}
