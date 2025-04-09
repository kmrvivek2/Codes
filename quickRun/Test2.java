package quickRun;

import java.util.Map;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        //System.out.println("2%5 :"+(2%5));
        //System.out.println("3%10 :"+(3%10));
        //System.out.println("9%4 :"+(9%4));

        checkStringValue();
    }

    // Find the character that occurred maximum times in a string
    public static void checkStringValue(){
        String str= "abvcdjcccgggghgghcbvhgc";
        //str="aabbccddeeffgg";
        //str="";
        Map<Character, Long> mappedStr =
                str.chars()
                        .mapToObj(c-> (char) c)
                        .collect(Collectors.groupingBy(c->c, Collectors.counting()));

        System.out.println("mappedStr :"+mappedStr);

        mappedStr.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(m-> System.out.println("Character "+m.getKey()+" occurred maximum "+m.getValue()+" times."));
    }
}
