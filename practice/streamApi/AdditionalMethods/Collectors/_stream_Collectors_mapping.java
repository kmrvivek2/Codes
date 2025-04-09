package practice.streamApi.AdditionalMethods.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _stream_Collectors_mapping {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Java", "Stream", "API");
        System.out.println(
                words.stream()
                        .collect(
                                Collectors.mapping(
                                        String::toUpperCase,
                                        Collectors.joining(" ")
                                )
                        )
        );
    }
}
