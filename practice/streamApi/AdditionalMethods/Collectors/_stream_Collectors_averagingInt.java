package practice.streamApi.AdditionalMethods.Collectors;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _stream_Collectors_averagingInt {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8,9,10};

        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.averagingInt(i->i)));
    }
}
