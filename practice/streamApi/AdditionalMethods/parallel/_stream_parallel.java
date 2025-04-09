package practice.streamApi.AdditionalMethods.parallel;

import java.util.Arrays;
import java.util.List;

public class _stream_parallel {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        /*
            In Java, the Stream API allows for functional-style operations on collections of data. One of its powerful features is the ability to process data in parallel, leveraging multiple CPU cores for better performance.

            Parallel Streams:
            A parallel stream in Java splits the data into multiple sub-streams, processes them in parallel, and then combines the results. This can significantly speed up operations on large datasets.
         */

        //parallel(): Returns a parallel stream
        list.stream().parallel().forEach(System.out::println);
    }
}
