package random;

/*
You have Integer array list and it contain some duplicate elements
find out the second highest occurrence of the duplicate element from the list
 */

import java.util.*;

public class _DuplicateElementOccurrence {

    public static void main(String []args){
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(3);
        al.add(1);
        al.add(2);
        al.add(2);
        al.add(2);

        findOcuurance(al);
    }

    public static void findOcuurance(ArrayList<Integer> a){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int x: a){
            map.put(x, (map.getOrDefault(x,0)+1));
        }

        System.out.println(map);

        List<Integer> l = new ArrayList<Integer>(map.values());
        Collections.sort(l,(i1,i2)-> i1>i2?-1:(i1<i2)?1:0);

        System.out.println(l);

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()==l.get(1)) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
                break;
            }
        }

    }
}
