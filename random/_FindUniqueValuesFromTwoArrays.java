package random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _FindUniqueValuesFromTwoArrays {

    public static void main(String arg[]){

        int []arr1 = {1,4,2,6,7,10,4};
        int []arr2 = {3,8,5,1,9,8,4};

        printUniqueUsingMap(arr1,arr2);
        printUniqueUsingSet(arr1,arr2);
    }

    public static void printUniqueUsingMap(int []arr1, int []arr2){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : arr1){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }
        for(int num : arr2){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }

        System.out.println("\nPrint using Map, Total count :"+frequencyMap.entrySet().size());
        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            if(entry.getValue() == 1){
                System.out.print(entry.getKey()+" ");
            }
        }
    }

    public static void printUniqueUsingSet(int []arr1, int []arr2){
        Set<Integer> uniqueSet = new HashSet<>();
        Set<Integer> duplicateSet = new HashSet<>();

        for (int num : arr1) {
            if (!uniqueSet.add(num)) {
                duplicateSet.add(num);
            }
        }
        for (int num : arr2) {
            if (!uniqueSet.add(num)) {
                duplicateSet.add(num);
            }
        }

        uniqueSet.removeAll(duplicateSet);

        System.out.println("\nPrint using Set, Total count :" + uniqueSet.size());
        for (int num : uniqueSet) {
            System.out.print(num + " ");
        }
    }
}
