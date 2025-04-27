package toc.y2025.interfaces;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("이름: " + name + ", 나이: " + age);
    }
}

class Student extends Person {
    String major;

    Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    void introduce() {
        System.out.println("이름: " + name + ", 나이: " + age + ", 전공: " + major);
    }
}

public class Test1 {
    public static void main(String[] args) {
        Student s = new Student("홍길동", 20, "컴퓨터공학");
        s.introduce();
    }
}
