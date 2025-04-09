package practice.streamApi.Creation;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Arrays_stream {
    public static void main(String[] args) {

        int[] arr = {1,2};
        //Arrays.stream(): Creates a stream from an array.
        IntStream stream = Arrays.stream(arr);
        System.out.println("Premitive int value");
        stream.forEach(System.out::println);


        String[] arr1 = {"1", "2"};
        System.out.println("Object Integer value");
        //Similarly we can create a stream from an array of objects using Arrays.stream() method.
        Stream<String> stream1 = Arrays.stream(arr1);
        stream1.forEach(System.out::println);
    }
}
