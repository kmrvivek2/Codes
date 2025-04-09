package practice.DSA.Arrays;

/*
You are given an array of integers arr[]. Your task is to reverse the given array.
Note: Modify the array in place.

https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/reverse-an-array
*/

public class _4_Reverse_Array {
    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 2, 6, 5};
        reverseArray(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
    }

    public static void reverseArray(int arr[]) {
        // code here
        if(arr.length > 1){
            int lastPoint=arr.length-1;
            for(int i=0;i<lastPoint;i++,lastPoint--){
                if(arr[i] != arr[lastPoint]){
                    int temp = arr[i];
                    arr[i] = arr[lastPoint];
                    arr[lastPoint] = temp;
                }
            }
        }
    }
}
