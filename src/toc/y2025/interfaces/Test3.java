package toc.y2025.interfaces;

public class Test3 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Animal();

        for (Animal a : animals) {
            a.sound();  // 동적 바인딩
        }
    }
}