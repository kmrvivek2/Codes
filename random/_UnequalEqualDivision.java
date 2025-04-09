package random;

public class _UnequalEqualDivision {
    public static void main(String[] args) {
        int num = 7;
        System.out.println(countUnequalEquals(num));
    }

    public static int countUnequalEquals(int N) {
        int count = 0;

        // Iterate over possible lengths for the first pair of equal segments
        for (int a = 1; a <= N / 2; a++) {
            // Iterate over possible lengths for the second pair of equal segments
            for (int b = 1; b <= N / 2; b++) {
                // Ensure the two pairs are not of the same length
                if (a != b) {
                    // Check if the total length matches N
                    if (2 * a + 2 * b == N) {
                        System.out.println("a: " + a + " b: " + b);
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
