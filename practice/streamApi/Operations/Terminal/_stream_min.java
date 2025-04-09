package practice.streamApi.Operations.Terminal;

import java.util.Arrays;
import java.util.List;

public class _stream_min {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5 , 2, 1, 10, 3);
        Integer min = ls.stream()
                .min(Integer::compareTo)
                .get();

        System.out.println(min);
    }
}
