package quickRun;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int arr[] = {4,3,2,1,6,9,8,7,5};
        int minOperationCount = findMinOperations(arr);
        System.out.println("Minimum operation count: " + minOperationCount);
    }

    private static int findMinOperations(int[] arr) {
        int n = arr.length;
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        boolean[] visited = new boolean[n];
        int minOperations = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i] == sortedArr[i]) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = indexOf(arr, sortedArr[j]);
                cycleSize++;
            }

            if (cycleSize > 0) {
                minOperations += (cycleSize - 1);
            }
        }

        return minOperations;
    }

    private static int indexOf(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
