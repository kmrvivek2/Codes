package practice.streamApi.AdditionalMethods.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _stream_Collectors_groupingBy_2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "mango", "apple", "mango", "apple", "banana", "mango", "apple");

        Stream<String> streamList = list.stream();
        //System.out.println(streamList.collect(Collectors.groupingBy(s -> s)));
        //System.out.println(streamList.collect(Collectors.groupingBy(s -> s, Collectors.counting())));
        //System.out.println(streamList.collect(Collectors.groupingBy(s -> s, Collectors.summarizingInt(String::length))));
        System.out.println(streamList.collect(Collectors.groupingBy(s -> s, Collectors.joining(", "))));
    }
}
