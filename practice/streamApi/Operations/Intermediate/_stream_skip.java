package practice.streamApi.Operations.Intermediate;

import java.util.Arrays;
import java.util.List;

public class _stream_skip {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ls.stream()
                .skip(4)
                .forEach(System.out::println);
    }
}
