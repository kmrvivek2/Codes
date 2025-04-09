package practice.DSA.Arrays;

/*
You are given an array arr[] of non-negative integers.
Your task is to move all the zeros in the array to the right end while maintaining the relative order of the non-zero elements.
The operation must be performed in place, meaning you should not use extra space for another array.

https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/move-all-zeroes-to-end-of-array0751
https://www.geeksforgeeks.org/move-zeroes-end-array/

 */

public class _3_Shift_All_Zeros_To_Right {
    public static void main(String[] args) {
        int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
        pushZerosToEnd(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
    }

    public static void pushZerosToEnd(int[] arr) {

        // [Better Approach] Two Traversals – O(n) Time and O(1) Space - without extra space
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0){
                arr[count++] = arr[i];
            }
        }

        while(count<arr.length){
            arr[count++] = 0;
        }

        /*
        // [Expected Approach] One Traversal – O(n) Time and O(1) Space
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0){
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
                ++count;
            }
        }
*/
        /*
        // [Worst Approach] One Traversal – O(n^2) Time and O(1) Space
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++) {
                if (arr[i] == 0 && arr[j] != 0) {
                    arr[i] = arr[j];
                    arr[j] = 0;
                }
            }
        }
 */
    }
}
