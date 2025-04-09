package practice.Threading;

public class _7_EvenOdd_Sample {

    private static int value = 1;
    private static Object lock = new Object();

    public void printOdd(int upperLimit) {
        synchronized (lock){
           while(value <= upperLimit) {
               if(value % 2 != 0){
                   System.out.println(Thread.currentThread().getName() + " " + value);
                   value++;
                   lock.notify();
               } else {
                   try {
                       lock.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
        }
    }

    public void printEven(int upperLimit) {
        synchronized (lock){
            while(value <= upperLimit) {
                if(value % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + " " + value);
                    value++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
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
