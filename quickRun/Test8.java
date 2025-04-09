package quickRun;

import java.util.PriorityQueue;

public class Test8 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        System.out.println(minCost(arr));
    }

    public static int minCost(int[] arr) {

        // Create a priority queue
        // By default, the priority queue is in
        // increasing order
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.add(num);
        }

        // Initialize result
        int res = 0;

        // While size of priority queue is more than 1
        while (pq.size() > 1) {

            // Extract shortest two ropes from pq
            int first = pq.poll();
            int second = pq.poll();

            // Connect the ropes: update result and
            // insert the new rope to pq
            res += first + second;
            pq.add(first + second);
        }

        return res;
    }
}
