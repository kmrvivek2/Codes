package practice.streamApi.Operations.Terminal;

import java.util.Arrays;
import java.util.List;

public class _stream_toArray {
    public static void main(String[] args) {
         List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5 , 2, 1, 10, 3);
         Integer[] arr = ls.stream()
                 .toArray(Integer[]::new);

         for (Integer i : arr) {
             System.out.print(i+", ");
         }
         System.out.println();


         List<String> ls2 = Arrays.asList("a", "b", "c", "d", "e");
            String[] arr2 = ls2.stream()
                    .toArray(String[]::new);

            for (String i : arr2) {
                System.out.print(i+", ");
            }
    }
}
