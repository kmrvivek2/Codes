package practice.streamApi.Operations.Terminal;

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;

public class _stream_collect {
    public static void main(String[] args) {

                // Create a stream of strings
                Stream<String> stream = Stream.of("apple", "banana", "apricot", "avocado", "orange");

                //Stream.collect(Collector collector): Performs a mutable reduction operation on the elements of this stream using a Collector.
                List<String> list = stream.collect(Collectors.toList());

                // Print each string in the resulting list
                list.forEach(System.out::println);
    }
}
