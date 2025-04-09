package practice.streamApi.Operations.Terminal;

import java.util.Arrays;

public class _stream_count {
    public static void main(String[] args) {

            // Create a stream of strings
            String[] strings = {"apple", "banana", "apricot", "avocado", "orange"};

            //Stream.count(): Returns the count of elements in this stream.
            long count = 0;
            count = Arrays.stream(strings).count();

            // Print the count of the strings
            System.out.println("Count of the strings: " + count);
    }
}
