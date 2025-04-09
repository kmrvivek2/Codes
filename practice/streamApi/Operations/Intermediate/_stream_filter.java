package practice.streamApi.Operations.Intermediate;

import java.util.stream.Stream;

public class _stream_filter {
    public static void main(String[] args) {

        // Create a stream of strings
        Stream<String> stream = Stream.of("apple", "banana", "apricot", "avocado", "orange");

        //Stream.filter(): Returns a stream consisting of the elements of this stream that match the given predicate.
        Stream<String> filtered = stream.filter(s -> s.startsWith("a"));

        // Print each string in the resulting stream
        filtered.forEach(System.out::println);
    }
}
