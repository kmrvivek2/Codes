package practice.Threading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _18_SynchorinedCollection {
    public static void main(String[] args) {
        /*
            Below line will give error -> OutOfBound Exception
            As t2 is trying to add element to the same list which is already added by t1
         */

        //List<Integer> l1 = new ArrayList<>();
        List<Integer> l1 = Collections.synchronizedList(new ArrayList<>());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i < 2000; i++) {
                    l1.add(i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i < 2000; i++) {
                    l1.add(i);
                }
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("List Size:"+l1.size());
    }
}
