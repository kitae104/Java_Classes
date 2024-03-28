package lambda_stream.collect;

import java.util.Collections;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.reducing;

// reducing : 스트림의 요소를 줄여나가면서 연산을 수행한다.(그룹별 리듀싱(sum, count, ...) 가능)
public class StreamReducing {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints(1, 46).distinct().limit(6);
        intStream.forEach(i -> System.out.print(i + ", "));
        System.out.println();

        IntStream intStream2 = new Random().ints(1, 46).distinct().limit(6);
        OptionalInt max = intStream2.reduce(Integer::max);       // 최대값
        System.out.println("max = " + max.getAsInt());

        IntStream intStream3 = new Random().ints(1, 46).distinct().limit(6);
        Optional<Integer> max2 = intStream3.boxed().collect(reducing(Integer::max));       // 최대값
        System.out.println("max2 = " + max2.get());
    }
}
