package practice.streamApi.Creation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Collection_stream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2);

        //Collection.stream(): Creates a stream from a collection.
        Stream<Integer> stream = list.stream();

        System.out.println("Stream created from a collection:");
        stream.forEach(System.out::println);
    }
}
