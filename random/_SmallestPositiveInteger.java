package random;

/*
that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 */

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class _SmallestPositiveInteger {
    public static void main(String[] args) {
        int[] A = {3, 4, -1, 1};
        System.out.println("Smallest positive integer missing: " + findSmallestPositiveInteger(A));

        A = new int[]{1, 3, 6, 4, 1, 2};
        System.out.println("Smallest positive integer missing: " + findSmallestPositiveInteger(A));

        A = new int[]{1, 2, 3};
        System.out.println("Smallest positive integer missing: " + findSmallestPositiveInteger(A));

        A = new int[]{-1, -2};
        System.out.println("Smallest positive integer missing: " + findSmallestPositiveInteger(A));

    }

    public static int findSmallestPositiveInteger(int[] A) {
        Set<Integer> positiveNumbers = Arrays.stream(A)
                .filter(num -> num > 0)
                .boxed()
                .collect(Collectors.toSet());

        int smallestPositive = 1;
        while (positiveNumbers.contains(smallestPositive)) {
            smallestPositive++;
        }

        return smallestPositive;
    }

}
