package practice.streamApi.Operations.Terminal;

import java.util.stream.Stream;

public class _stream_forEach {
    public static void main(String[] args) {

            // Create a stream of strings
            Stream<String> stream = Stream.of("apple", "banana", "apricot", "avocado", "orange");

            //Stream.forEach(Consumer action): Performs an action for each element of this stream.
            stream.forEach(System.out::println);
    }
}
