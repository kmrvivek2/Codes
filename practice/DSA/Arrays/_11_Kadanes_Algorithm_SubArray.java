package practice.DSA.Arrays;

/*
Given an integer array arr[]. You need to find the maximum sum of a subarray.
https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/kadanes-algorithm-1587115620
https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */

public class _11_Kadanes_Algorithm_SubArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));
    }

    public static int maxSubarraySum(int[] arr){
        int res = arr[0], subArrayEnd = arr[0];
        int n = arr.length;

        for(int i=1;i<n;i++){
            subArrayEnd = Math.max(arr[i], subArrayEnd + arr[i]);
            System.out.println("arr["+i+"] = "+arr[i]+" subArrayEnd = "+subArrayEnd);
            res = Math.max(res, subArrayEnd);
        }

        return res;
    }
}
