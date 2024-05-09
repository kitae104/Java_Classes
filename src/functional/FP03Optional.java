package functional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class FP03Optional {
    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Mango", "Orange", "Cherry");
        Optional<String> optional = fruits.stream()
                .filter(fruit -> fruit.startsWith("B"))
                .findFirst();

        System.out.println(optional);
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());
        System.out.println(optional.get());

        fruits = List.of("Apple", "Banana", "Mango", "Orange", "Cherry");
        String fruit = fruits.stream()
                .filter(f -> f.startsWith("T"))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No fruit found!"));  // 예외 처리
        System.out.println(fruit);
        System.out.println("==========================");
    }
}
