package practice.Threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _9_EvenOdd_Sample_Reentrant {
    private static int value = 1;
    private static Lock lock = new ReentrantLock();

    public void printOdd(int upperLimit) {
        lock.lock();
        try {
            while (value <= upperLimit) {
                if (value % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + " " + value);
                    value++;
                } else {
                    lock.unlock();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printEven(int upperLimit) {
        lock.lock();
        try {
            while(value <= upperLimit) {
                if(value % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + " " + value);
                    value++;
                } else {
                    lock.unlock();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        final int upperLimit = 10;

        Thread to = new Thread(new Runnable() {
            @Override
            public void run() {
                new _7_EvenOdd_Sample().printOdd(upperLimit);
            }
        }, "Thread-Odd");

        Thread te = new Thread(new Runnable() {
            @Override
            public void run() {
                new _7_EvenOdd_Sample().printEven(upperLimit);
            }
        }, "Thread-Even");

        to.start();
        te.start();
    }
}
