package quickRun;

public class App2 {
    public static void main(String[] args) {

        int[] arr1 = {-1,2,3,3,4,5,-1};
        int k = 4;
//        System.out.println("Sum :"+consecutiveWindowSum(arr1, k)); // here k is the window size

        int[] arr2 = {2,5,1,10,10};
        k = 14;
//        System.out.println("Longest SubArray :"+consecutiveWindowLongestSubArray(arr2, 14)); // here k is the highest sum

        maxPointsCards(arr2, 3);
    }

    private static int consecutiveWindowSum(int[] arr, int k) {
        int sum = 0, i = 0, n = arr.length;

        for(int j = 0; j < (i+k); j++) {
            sum += arr[j];
        }

        while(k < n) {
            int total = sum - arr[i] + arr[k];
            //System.out.println("i: " + i + " k: " + k + " sum: " + sum + " total: " + total);
            if(total > sum) {
                sum = total;
            }

            i++;
            k++;
        }

        return sum;
    }

    private static int consecutiveWindowLongestSubArray(int[] arr, int k) {
        int sum = 0, n = arr.length;
        int l = 0, r = 0, len = 0;
        int maxSum = 0;

        while(r < n) {
            System.out.println("l: " + l + " r: " + r + " sum: " + sum + " len: " + len);
            sum += arr[r];
            if(sum > k) {
                sum -= arr[l];
                ++l;
            }

            if(sum <= k) {
                len = Math.max(len, r-l+1);
                maxSum = sum;
            }

            ++r;
        }

        System.out.println("l: " + l + " r: " + r + " sum: " + sum + " len: " + len);
        System.out.println();
        return len;
    }

    private static void printZeroSumElements(int[] arr) {
        int n = arr.length;
        int l = 0,r = 0;

        while(r < n) {
            if((arr[l]+arr[r]) == 0)
                System.out.println("arr[" + l + "] -> " + arr[l] + " arr[" + r + "] -> " + arr[r]);
            r++;
        }
    }

    private static void maxPointsCards(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0, rsum = 0, msum = 0;

        for(int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }

        msum = lsum;
        //System.out.printf("lsum: %d rsum: %d msum: %d\n", lsum, rsum, msum);

        for(int i = k-1; i>=0; i--) {
            lsum -= cardPoints[i];
            rsum += cardPoints[n-1];

            msum = Math.max(msum, lsum+rsum);
            //System.out.printf("lsum: %d rsum: %d msum: %d\n", lsum, rsum, msum);
            --n;
        }

        System.out.println("Max Points: " + msum);
    }
}