package practice.GenericUse;

import java.util.List;

public class UnBondedWildCardExample {
/*
    public static void print(List<Object> list) {
        for(Object o : list)
            System.out.println(o);
*/

    public static void print(List<?> list) {
        for(Object o : list)
            System.out.println(o);

    }

    public static void main(String[] args) {
        // This will give compile time error: incompatible types: List<Integer> cannot be converted to List<Object>
        // For collection, List<Object> is not supertype of List<Integer>
/*
        List<Integer> list = List.of(1, 2, 3);
        print(list);
*/
        List<Integer> list1 = List.of(1, 2, 3);
        print(list1);

        List<String> list2 = List.of("Abc", "Xyz");
        print(list2);
    }
}
