package practice.streamApi.Operations.Terminal;

import java.util.Arrays;
import java.util.List;

public class _stream_max {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5 , 2, 1, 10, 3);
        Integer max = ls.stream()
                .max(Integer::compareTo)
                .get();

        System.out.println(max);
    }
}
