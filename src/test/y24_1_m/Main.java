package test.y24_1_m;

// 추상 클래스 Animal 정의
abstract class Animal {
    private String name;
    private String type;

    // 이름과 종류를 받아 초기화하는 생성자
    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // 추상 메서드 - 하위 클래스에서 반드시 구현해야 함
    public abstract void makeSound();

    // 이름을 반환하는 메서드
    public String getName() {
        return name;
    }

    // 종류를 반환하는 메서드
    public String getType() {
        return type;
    }
}

// Animal 클래스를 확장한 Dog 클래스 정의
class Dog extends Animal {
    private int age;

    // 이름, 종류, 나이, 크기를 받아 초기화하는 생성자
    public Dog(String name, String type, int age) {
        super(name, type); // 부모 클래스의 생성자 호출
        this.age = age;

    }

    // 나이를 반환하는 메서드
    public int getAge() {
        return age;
    }

    // 추상 메서드 구현
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
