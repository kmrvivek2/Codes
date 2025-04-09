package practice.streamApi.Operations.Intermediate;

import java.util.stream.Stream;

public class _stream_map {
    public static void main(String[] args) {

        // Create a stream of strings
        Stream<String> stream = Stream.of("apple", "banana", "apricot", "avocado", "orange");

        // Use map to convert each string to uppercase
        stream.map(String::toUpperCase)
                // Print each string in the resulting stream
                .forEach(System.out::println);
    }
}
