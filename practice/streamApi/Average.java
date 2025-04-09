package practice.streamApi;

//Write a Java program to calculate the average of a list of integers using streams.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Average {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        double avg = ls.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("Average of the list of integers: " + avg);
    }
}
