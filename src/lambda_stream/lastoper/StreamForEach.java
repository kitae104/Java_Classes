package lambda_stream.lastoper;

import java.util.stream.IntStream;

public class StreamForEach {
    public static void main(String[] args) {
        IntStream.range(1, 10).sequential().forEach(System.out::print);
        System.out.println();

        IntStream.range(1, 10).parallel().forEach(System.out::print);           // 순서가 보장되지 않음
        System.out.println();

        IntStream.range(1, 10).parallel().forEachOrdered(System.out::print);    // 순서가 보장됨
        System.out.println();
    }
}
