package practice.streamApi;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _Stream_EvenCharacters {
    public static void main(String[] args) {
        String s = "Welcome";
        String s1 = IntStream.range(0, s.length())
                .filter(c -> c%2 == 0)
                .mapToObj(s::charAt)
                .peek(System.out::println)
                .map(String::valueOf)
                .peek(System.out::println)
                .collect(Collectors.joining());

        System.out.println(s1); // Welcome -> Wloe
    }
}