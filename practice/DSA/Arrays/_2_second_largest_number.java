package practice.DSA.Arrays;

import java.util.Arrays;

/*
Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.
Note: The second largest element should not be equal to the largest element.

https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/second-largest3735
*/

public class _2_second_largest_number {
    public static void main(String[] args) {
        int []arr= {12, 35, 1, 10, 34, 1};
        System.out.println("Original string :"+ Arrays.toString(arr));
        System.out.println("getSecondLargest :"+getSecondLargest(arr));
    }

    public static int getSecondLargest(int[] arr) {
        // Code Here
        int firstLarge = arr[0];
        int secondLarge = Integer.MIN_VALUE;

        for(int i=1;i<arr.length;i++){
            if(arr[i]>firstLarge){
                secondLarge = firstLarge;
                firstLarge = arr[i];
            }
            else if(arr[i]<firstLarge && arr[i]>secondLarge)
                secondLarge = arr[i];
        }

        if(secondLarge == Integer.MIN_VALUE)
            return -1;
        else
            return secondLarge;
    }
}
