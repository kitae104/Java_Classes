package lambda_stream.practice;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMap {
    public static void main(String[] args) {
        // map 연산을 이용한 스트림 생성
        Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex2.bak"), new File("Ex3.txt"));

        Stream<String> fileNameStream = fileStream.map(File::getName);
        fileNameStream.forEach(System.out::println);

        // 파일 스트림에서 파일 확자자를 중복없이 뽑아내기
        fileStream = Stream.of(new File("Ex1.java"), new File("Ex2.bak"), new File("Ex3.txt"));
        fileStream.map(File::getName)   // 파일 이름으로 구성된 스트림 생성
                .map(name -> name.substring(name.indexOf(".") + 1)) // 확장자만 뽑아내기
                .map(String::toUpperCase)   // 모두 대문자로 변환
                .distinct()                 // 중복 제거
                .forEach(System.out::println);

        // flatMap 연산을 이용한 스트림 생성
        Stream<String[]> strArrStream = Stream.of(
                new String[]{"abc", "def", "jkl"},
                new String[]{"ABC", "DEF", "JKL"}
        );

        // flatMap()을 이용하여 스트림의 스트림을 하나의 스트림으로 합친다.
        Stream<String> strStream = strArrStream.flatMap(Arrays::stream);
        strStream.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +"))) // line을 하나 이상의 공백으로 분리한 스트림 생성
                .map(String::toLowerCase) // 모두 소문자로 변환
                .distinct() // 중복 제거
                .sorted()   // 정렬
                .forEach(System.out::println);  // 출력


    }
}
