package lambda_stream.lastoper;

import java.util.stream.IntStream;

// reduce() 메소드는 최종 연산 : 스트림의 요소를 줄여나가면서 연산을 수행한다.
// identity 매개변수는 초기값을 설정한다.
// accumulator 이전 연산 결과와 스트림의 요소에 수행할 연산
// combiner 병렬 스트림의 경우 각각의 결과를 병합할 때 사용
public class StreamReduce {
    public static void main(String[] args) {
        // int reduce(int identity, IntBinaryOperator op)
        int count = IntStream.range(1, 10).reduce(0, (a, b) -> a + 1);
        System.out.println("count = " + count);

        int sum = IntStream.range(1, 10).reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        // 위의 구문과 동일한 동작을 수행함
        IntStream intStream = IntStream.range(1, 10);
        int x = 0;
        for(int y : intStream.toArray()){
            x = x + y;
        }
        System.out.println("x = " + x);

        int max = IntStream.range(1, 10).reduce(0, (a, b) -> a > b ? a : b);
        System.out.println("max = " + max);

        int min = IntStream.range(1, 10).reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
        System.out.println("min = " + min);
    }
}
