package practice.streamApi.Operations.Intermediate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _stream_boxed {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

        /*
            In Java, the boxed() method is used to convert a stream of primitive types (like int, long, double)
            into a stream of their corresponding wrapper class objects (Integer, Long, Double).
            This is useful when you need to perform operations that require objects rather than primitives.
        */

        List<Integer> integerList = intStream.boxed().collect(Collectors.toList());
        System.out.println(integerList); // Output: [1, 2, 3, 4, 5]
    }
}
