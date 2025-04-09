package practice.streamApi.AdditionalMethods;

import java.util.stream.Stream;

public class _stream_skip {
    public static void main(String[] args) {

        // Create a stream of strings
        Stream<String> stream = Stream.of("apple", "banana", "apricot", "apple", "orange", "banana");

        //skip(): Skips the first N elements
        Stream<String> skipped = stream.skip(1);

        skipped.forEach(System.out::println);
    }
}
