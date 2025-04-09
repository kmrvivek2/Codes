package random;

import java.util.HashMap;
import java.util.Map;

public class _StringsLengthFrequency {
    public static void main(String []arg){

        Map<Integer,Integer> mapString = new HashMap<>();
        String []str = {"apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "melon", "pear"};

        for(String s : str){
            int len = s.length();
            mapString.put(len, mapString.getOrDefault(len,0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : mapString.entrySet()) {
            System.out.println("String Length: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }
}
