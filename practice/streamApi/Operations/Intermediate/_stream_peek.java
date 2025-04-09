package practice.streamApi.Operations.Intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _stream_peek {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "avocado", "orange");
        List<String> filteredList = list.stream()
                .peek(s -> System.out.println("Before filter: " + s))
                .filter(s -> s.startsWith("a"))
                .peek(s -> System.out.println("After filter: " + s))
                .collect(Collectors.toList());

        System.out.println(filteredList);
    }
}
