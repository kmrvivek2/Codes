package practice.streamApi.Operations.Terminal;

import java.util.Arrays;

public class _stream_reduce {

    public static void main(String[] args) {

            // Create a stream of integers
            int[] numbers = {1, 2, 3, 4, 5};
            int sum = 0;

            //reduce(): Reduces elements to a single value
            //Stream.reduce(BinaryOperator accumulator): Performs a reduction on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced value, if any.
            //Stream.reduce(T identity, BinaryOperator accumulator): Performs a reduction on the elements of this stream, using the provided identity value and an associative accumulation function, and returns the reduced value.
            sum = Arrays.stream(numbers)
                    .reduce((a, b) -> a + b).getAsInt();

            // Print the sum of the integers
            System.out.println("Sum of the integers: " + sum);
    }
}
