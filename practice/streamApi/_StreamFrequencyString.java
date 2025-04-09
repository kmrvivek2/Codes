package practice.streamApi;

import java.util.stream.Collectors;

public class _StreamFrequencyString {
    public static void main(String[] args) {
        String s = "asdassdvbsasjdakjnbkc";
        String s1 = convertToFrequency(s);
        System.out.println("New String: "+s1);
    }

    private static String convertToFrequency(String s){
        String s1  = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .peek(System.out::println)
                .map(e -> e.getKey() + "" + e.getValue())
                .collect(Collectors.joining());

        System.out.println(s1);
        return s1;
    }
}