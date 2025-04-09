package practice.DSA.Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _1_second_smallest_number {
    public static void main(String[] args) {
        int []arr= {3,7,9,2,8};
        System.out.println("Original string :"+Arrays.toString(arr));
        //withoutUsingStream(arr);
        usingStream(arr);
    }

    public static void withoutUsingStream(int []arr){
        int temp;

        for(int i = 0;i<arr.length-1;i++){
            for(int j = i+1;j< arr.length;j++){
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        System.out.println("After sorting in accending order :"+Arrays.toString(arr));
        System.out.println("Second smallest element :"+arr[1]);
    }

    public static void usingStream(int []arr){
        Arrays.stream(arr)
                .sorted()
                .limit(2)
                .skip(1)
                .forEach(System.out::println);
    }
}
