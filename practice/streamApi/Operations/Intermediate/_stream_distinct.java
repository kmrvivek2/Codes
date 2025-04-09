package practice.streamApi.Operations.Intermediate;

import java.util.stream.*;

public class _stream_distinct {
    public static void main(String[] args) {

            // Create a stream of strings
            Stream<String> stream = Stream.of("apple", "banana", "apricot", "avocado", "apple", "orange");

            // Use distinct to remove duplicates
            Stream<String> distinct = stream.distinct();

            // Print each character in the resulting stream
            distinct.forEach(System.out::println);
    }
}
