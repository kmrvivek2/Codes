package quickRun;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Check3 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        l1.add(1);l1.add(2);l1.add(3);l1.add(4);
        l2.add(2);l2.add(4);l2.add(5);l2.add(6);

        List l3 = l1.stream()
                .filter(i -> l2.stream().anyMatch(j->j==i))
                .collect(Collectors.toList());

        System.out.println("List1 :"+l1);
        System.out.println("List2 :"+l2);
        System.out.println("List3 :"+l3);
    }
}
