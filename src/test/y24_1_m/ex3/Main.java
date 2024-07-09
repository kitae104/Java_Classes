package test.y24_1_m.ex3;

abstract class Animal {
    private String name;
    private String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public abstract void makeSound();
}

class Dog extends Animal {
    private int age;

    public Dog(String name, String type, int age) {
        super(name, type);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void makeSound() {
        System.out.println("멍멍!");
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        // Dog 객체 생성
        Dog dog = new Dog("멍멍이", "개", 3);
        System.out.println("개의 이름: " + dog.getName());
        System.out.println("개의 종류: " + dog.getType());
        System.out.println("개의 나이: " + dog.getAge());
        dog.makeSound();
    }
}