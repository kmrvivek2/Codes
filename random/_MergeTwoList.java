package random;

import java.util.ArrayList;

public class _MergeTwoList {

    public static void main(String []arg){
        usingArrayList();
    }

    public static void usingArrayList(){
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(3);
        l1.add(5);
        l1.add(7);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(4);
        l2.add(6);
        l2.add(8);

        ArrayList<Integer> mergedlist = mergeList(l1,l2);

        for(int i : mergedlist){
            System.out.print(i+" ");
        }
    }

    public static ArrayList<Integer> mergeList(ArrayList<Integer> l1, ArrayList<Integer> l2){

        ArrayList<Integer> merge = new ArrayList<>();
        int l1Size = 0;
        int l2Size = 0;

        while(l1Size < l1.size() && l2Size < l2.size() ){
            if(l1.get(l1Size) < l2.get(l2Size))
                merge.add(l1.get(l1Size++));
            else
                merge.add(l2.get(l2Size++));
        }

        if(l1Size != l1.size())
            merge.add(l1.get(l1Size++));

        if(l2Size != l2.size())
            merge.add(l2.get(l2Size++));

        return merge;
    }
}
