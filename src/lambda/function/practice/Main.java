package lambda.function.practice;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String s) {
                String[] parts = s.split(" "); // 공백으로 분리
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        // 위의 내용을 람다식으로 표현
        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };
        printWords.accept("AAA BBB CCC");
        printWordsLambda.accept("DDD EEE FFF");

        Consumer<String> printWordsForEach = setence -> {
            String[] parts = setence.split(" ");
            Arrays.asList(parts).forEach(System.out::println);
        };
        printWordsForEach.accept("GGG HHH III");

        Consumer<String> printWordsConcise = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(System.out::println);
        };
        printWordsConcise.accept("JJJ KKK LLL");

        // 아래의 everySecondChar 메소드를 람다식으로 변경
        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if(i % 2 ==1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // 람다식을 적용하여 결과 출력하기
        String result1 = everySecondChar.apply("1234567890");
        System.out.println(result1);

        String result2 = everySecondCharacter(everySecondChar, "1234567890");
        System.out.println(result2);

        // Supplier 를 이용하여 출력하기
        Supplier<String> msg = () -> "I love Java!";
        Supplier<String> msg2 = () -> {return "Test Supplier";};

        System.out.println(msg.get());
        System.out.println(msg2.get());
    }

    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if(i % 2 ==1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondCharacter(Function<String, String> func, String source){
        return func.apply(source);
    }
}
