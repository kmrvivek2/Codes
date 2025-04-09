package random;

import java.util.stream.IntStream;

public class _StreamExploration {

    public static void main(String []args){
        primeNumberInRange(10, 50);
    }

    public static void primeNumberInRange(int start, int end) {
        IntStream.range(start, end)
            .filter(_StreamExploration::isPrime)
            .forEach(System.out::println);
    }

    public static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number)
            .noneMatch(i -> number % i == 0);
    }
}
