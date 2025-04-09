package practice.streamApi.AdditionalMethods.Collectors;

import java.util.Arrays;
import java.util.List;

public class _stream_Collectors_joining {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Java", "Stream", "API");
        String result1 = words.stream()
                .collect(java.util.stream.Collectors.joining(", "));

        System.out.println(result1);

        String result2 = words.stream()
                .collect(java.util.stream.Collectors.joining(", ","[","]"));

        System.out.println(result2);
    }
}
