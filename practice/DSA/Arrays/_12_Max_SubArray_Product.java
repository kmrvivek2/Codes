package practice.DSA.Arrays;

/*
Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].
Note: It is guaranteed that the output fits in a 32-bit integer.

https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/maximum-product-subarray3604
https://www.geeksforgeeks.org/maximum-product-subarray/
 */

public class _12_Max_SubArray_Product {
    public static void main(String[] args) {
        int[] arr = {6, -3, -10, 0, 2};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] arr) {
        // code here
        int res=arr[0], maxProduct=arr[0], minProduct=arr[0];

        for(int i=1;i<arr.length;i++){
            maxProduct = max(arr[i],arr[i]*maxProduct, arr[i]*minProduct);
            minProduct = min(arr[i],arr[i]*maxProduct, arr[i]*minProduct);

            System.out.println(""+maxProduct+" "+minProduct);

            res = Math.max(res,maxProduct);
        }

        return res;
    }

    public static int max(int a,int b, int c){
        return Math.max(a,Math.max(b,c));
    }

    public static int min(int a,int b, int c){
        return Math.min(a,Math.min(b,c));
    }
}
