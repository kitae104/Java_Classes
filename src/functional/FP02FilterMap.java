package functional;

import java.util.List;

public class FP02FilterMap {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printOddNumbers(numbers);
        printEvenNumbers(numbers);
        printSquareOfEvenNumbers(numbers);
        printCubesOfOddNumbers(numbers);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        printAllCourses(courses);
        printCourseLength(courses);
    }

    private static void printCourseLength(List<String> courses) {
        courses.stream()
                .map(course -> course + " : " + course.length())
                .forEach(System.out::println);
    }

    private static void printAllCourses(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);

        courses.stream()
                .forEach(System.out::println);
    }

    private static void printEvenNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(FP02FilterMap::print);
        System.out.println();
    }

    private static void printSquareOfEvenNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0)          // 짝수만 (filter)
                .map(number -> number * number)             // 제곱 구하기 (map)
                .forEach(FP02FilterMap::print);
        System.out.println();
    }

    private static void printOddNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .forEach(FP02FilterMap::print);
        System.out.println();
    }

    private static void printCubesOfOddNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number * number)
                .forEach(FP02FilterMap::print);
        System.out.println();
    }

    private static void print(int number) {
        System.out.print(number + " ");
    }

}
