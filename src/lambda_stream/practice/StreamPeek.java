package lambda_stream.practice;

import java.io.File;
import java.util.stream.Stream;

public class StreamPeek {
    public static void main(String[] args) {
        Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex2.bak"), new File("Ex3.txt"));

        fileStream.map(File::getName)
                .peek(System.out::println)
                .filter(s -> s.indexOf('.') != -1)
                .peek(s -> System.out.printf("filename=%s%n", s))
                .map(s -> s.substring(s.indexOf('.') + 1))
                .map(String::toUpperCase)
                .peek(s -> System.out.printf("extension=%s%n", s))
                .distinct()
                .forEach(System.out::println);
    }
}
