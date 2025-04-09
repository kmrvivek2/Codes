package practice.streamApi.AdditionalMethods.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _stream_Collectors_partitioningBy {
    public static void main(String[] args) {
        partitioningOnString();
    }

    public static void partitioningOnString() {
        List<String> words = Arrays.asList("Hello", "World", "Java", "Stream", "API");
        System.out.println(
                words.stream().collect(Collectors.partitioningBy(word -> word.length() > 4))
        );
    }
}
