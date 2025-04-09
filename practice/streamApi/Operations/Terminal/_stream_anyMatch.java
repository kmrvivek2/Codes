package practice.streamApi.Operations.Terminal;

import java.util.Arrays;
import java.util.List;

public class _stream_anyMatch {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        boolean condition1 = ls.stream()
                .anyMatch(i -> i > 2);
        boolean condition2 = ls.stream()
                        .anyMatch(i -> i < 0);
        System.out.println(condition1);
        System.out.println(condition2);
    }
}
