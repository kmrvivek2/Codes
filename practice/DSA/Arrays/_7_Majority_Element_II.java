package practice.DSA.Arrays;
/*
You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array.
Note: The answer should be returned in an increasing format.

https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/majority-vote
https://www.geeksforgeeks.org/find-all-array-elements-occurring-more-than-%E2%8C%8An-3%E2%8C%8B-times/
https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _7_Majority_Element_II {
    public static void main(String[] args) {
        int arr1[] = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        printArray(arr1);
        List<Integer> ls1 = findMajority(arr1);
        System.out.println(ls1); // 5 6
        System.out.println();

        int arr2[] = {2,1,6,6,6,6,6,5,5,5,5};
        printArray(arr2);
        List<Integer> ls2 = findMajority(arr2);
        System.out.println(ls2); // 5 6
        System.out.println();

        int arr3[] = {1,3,4,4,4};
        printArray(arr3);
        List<Integer> ls3 = findMajority(arr3);
        System.out.println(ls3); // 5 6
        System.out.println();
    }

    public static List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        List<Integer> ls=new ArrayList<Integer>();
        int ele1=-1,ele2=-1,count1=0,count2=0;

        for(int ele:nums) {
            if (ele == ele1)
                ++count1;
            else if (ele == ele2)
                ++count2;
            else if (count1 == 0) {
                ele1 = ele;
                ++count1;
            } else if (count2 == 0) {
                ele2 = ele;
                ++count2;
            } else {
                --count1;
                --count2;
            }
        }

        count1=0;count2=0;
        for(int a:nums){
            if(ele1==a)
                ++count1;
            if(ele2==a)
                ++count2;
        }

        double majority = nums.length/3;
        if(count1>majority)
            ls.add(ele1);
        if(count2>majority)
            ls.add(ele2);

        Collections.sort(ls);
        return ls;
    }

    public static void printArray(int arr[]){
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
