package lambda.function.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        String[] names = {"Anna", "Bob", "Carole", "David", "Ed", "Fred", "Gary"};
        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("---> Transform to Uppercase");
        System.out.println(Arrays.toString(names));

        // 배열을 리스트로 만들기
        List<String> backedByArray = Arrays.asList(names);

        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D') + ".");
        System.out.println("---> Add random middle initial");
        System.out.println(Arrays.toString(names));

        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split("")[0]));
        System.out.println("---> Add reversed name as last name");
        Arrays.asList(names).forEach(System.out::println);

        List<String> newList = new ArrayList<>(List.of(names));
        newList.removeIf(s -> s.substring(0, s.indexOf(" "))
                .equals(s.substring(s.lastIndexOf(" ") + 1)));
        System.out.println("---> Remove names with same first and last name");
        newList.forEach(System.out::println);
    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }
}
