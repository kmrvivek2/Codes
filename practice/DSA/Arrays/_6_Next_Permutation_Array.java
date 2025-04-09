package practice.DSA.Arrays;

/*
Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order).
Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.

https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/next-permutation5226
https://www.geeksforgeeks.org/next-permutation/
 */

public class _6_Next_Permutation_Array {
    public static void main(String[] args) {

        int arr1[] = {2, 4, 1, 7, 5, 0};
        printArray(arr1);
        nextPermutation(arr1);
        printArray(arr1); // 2 4 5 0 1 7
        System.out.println();

        int arr2[] = {3, 2, 1};
        printArray(arr2);
        nextPermutation(arr2);
        printArray(arr2); // 1 2 3

        System.out.println();
        int arr3[] = {3,4,2,5,1};
        printArray(arr3);
        nextPermutation(arr3);
        printArray(arr3); // 3 4 5 1 2

        System.out.println();
        int arr4[] = {1,4,3,2};
        printArray(arr4);
        nextPermutation(arr4);
        printArray(arr4); // 2 1 3 4
    }

    public static void printArray(int arr[]){
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void nextPermutation(int[] arr) {
        // code here
        int pivot1=-1;
        int n=arr.length;

        for(int i=n-1;i>0;i--) {
            if(arr[i]>arr[i-1]) {
                pivot1=i-1;
                break;
            }
        }

        if(pivot1==-1){
            reverse(arr,0,n-1);
            return;
        }

        //System.out.println("pivot1 :"+pivot1);
        //printArray(arr);

        for(int i=n-1;i>pivot1;i--){
            if(arr[i]>arr[pivot1]) {
                //System.out.println("pivot2 :"+i);
                swap(arr,pivot1,i);
                break;
            }
        }

        //printArray(arr);
        reverse(arr,pivot1+1,n-1);
    }

    public static void reverse(int arr[],int start, int last) {
        while(start<last) {
            if(arr[start] != arr[last]) {
                swap(arr,start,last);
            }

            ++start;
            --last;
        }
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
