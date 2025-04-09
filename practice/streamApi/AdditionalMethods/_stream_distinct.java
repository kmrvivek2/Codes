package practice.streamApi.AdditionalMethods;

import java.util.stream.Stream;

public class _stream_distinct {
    public static void main(String[] args) {

        // Create a stream of strings
        Stream<String> stream = Stream.of("apple", "banana", "apricot", "apple", "orange", "banana");

        //distinct(): Removes duplicate elements
        Stream<String> distinct = stream.distinct();

        distinct.forEach(System.out::println);
    }
}
