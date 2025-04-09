package practice.streamApi.Creation;

import java.util.stream.Stream;

public class Stream_of {
    public static void main(String[] args) {

        //Stream.of(): Creates a stream from a set of values.
        Stream.of(1, 2).forEach(System.out::println);
    }
}
