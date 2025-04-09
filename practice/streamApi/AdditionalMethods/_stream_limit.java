package practice.streamApi.AdditionalMethods;

import java.util.stream.Stream;

public class _stream_limit {
    public static void main(String[] args) {

        // Create a stream of strings
        Stream<String> stream = Stream.of("apple", "banana", "apricot", "apple", "orange", "banana");

        //limit(): Limits the number of elements
        Stream<String> limited = stream.limit(3);

        limited.forEach(System.out::println);
    }
}
