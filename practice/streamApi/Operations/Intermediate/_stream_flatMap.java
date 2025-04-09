package practice.streamApi.Operations.Intermediate;

import java.util.stream.Stream;

public class _stream_flatMap {
    public static void main(String[] args) {

        // Create a stream of strings
        Stream<String> stream = Stream.of("apple", "banana", "apricot", "avocado", "orange");

        // Use flatMap to split each string into a stream of its characters
        Stream<String> flatMap = stream.flatMap(s -> Stream.of(s.split("")));

        // Print each character in the resulting stream
        flatMap.forEach(System.out::println);
    }
}
