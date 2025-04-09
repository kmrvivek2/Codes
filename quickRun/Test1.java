package quickRun;

import java.util.Hashtable;
import java.util.Map;
import java.util.stream.IntStream;

public class Test1 {
    public static void main(String[] args) {
        Map<Character,Integer> num = new Hashtable<Character,Integer>();
        IntStream.rangeClosed('a', 'z')
                .forEach(i -> num.put((char) i, i - 'a' + 1));

        // Print the map to verify
//        num.forEach((k, v) -> System.out.println(k + ": " + v));

        String names = "china";
/*
        char[] namesChar = names.toCharArray();

        int sum = IntStream.range(0, namesChar.length)
                .map(i -> num.get(namesChar[i]))
                .sum();
        System.out.println(names+":"+sum);
*/

        System.out.println(names+":"+names.chars().map(i -> num.get((char) i)).sum());
    }
}
