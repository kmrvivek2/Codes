package practice.streamApi.Operations.Terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class _stream_findAny {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("apple", "banana", "apricot", "avocado", "orange");
        Optional<String> firstWord1 = ls.stream()
                .filter(s->s.startsWith("a"))
                        .findAny();

        System.out.println(firstWord1);
        System.out.println(firstWord1.get());

        Optional<String> firstWord2 = ls.stream()
                .filter(s->s.startsWith("t"))
                .findAny();

        System.out.println(firstWord2);

        // Exception in thread "main" java.util.NoSuchElementException: No value present
        // System.out.println(firstWord2.get());
    }
}
