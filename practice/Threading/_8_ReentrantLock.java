package practice.Threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _8_ReentrantLock {
    private static int counter = 0;
    private static Lock lock = new ReentrantLock();

    private static void increament() {
        lock.lock();
        try{
            for(int i = 0;i<10000;i++)
                counter++;
        } finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            increament();
        });

        Thread t2 = new Thread(() -> {
            increament();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Counter: " + counter);
    }
}
