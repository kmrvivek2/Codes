package practice.streamApi.Operations.Intermediate;

import java.util.stream.Stream;

public class _stream_sorted {
    public static void main(String[] args) {

        // Create a stream of strings
        Stream<String> stream = Stream.of("apple", "banana", "apricot", "avocado", "orange");

        //Stream.sorted(): Returns a stream consisting of the elements of this stream, sorted according to natural order.
        //Stream.sorted(Comparator comparator): Returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.
        Stream<String> sortedStream = stream.sorted();

        // Print each string in the resulting stream
        sortedStream.forEach(System.out::println);
    }
}
