package practice.DSA.Arrays;
/*
Given an array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.
Note: Consider the array as circular.

https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/rotate-array-by-n-elements-1587115621
https://www.geeksforgeeks.org/array-rotation/
*/

public class _5_Rotate_Array_CounterClockwise {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5};
        rotateArr(arr1, 2);
        for(int a:arr1){
            System.out.print(a+" ");
        }

        System.out.println();

        int arr2[] = {1,2,3,4,5};
        rotateArr(arr2, 9);
        for(int a:arr2){
            System.out.print(a+" ");
        }
    }

    static void rotateArr(int arr[], int d) {
        // add your code here
        if(arr.length > 1){
            int n = arr.length;
            d = d%n;

            reverse(arr,0,d-1);
            reverse(arr,d,n-1);
            reverse(arr,0,n-1);
        }
    }

    static void reverse(int arr[], int start, int last) {
        while(start<last){
            if(arr[start] != arr[last]){
                int temp = arr[start];
                arr[start] = arr[last];
                arr[last] = temp;
            }

            ++start;
            --last;
        }
    }
}
