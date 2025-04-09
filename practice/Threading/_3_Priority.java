package practice.Threading;

public class _3_Priority {
    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName()+" : "+Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
//        System.out.println(Thread.currentThread().getName()+" : "+Thread.currentThread().getPriority());

        // A thread with higher priority will get more CPU time.
        Thread t1 = new Thread(new Worker());
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        // Even main thread have priority 5 but it will be processed first from Thread t1 because main thread is parent thread.
        System.out.println("Main thread priority : "+Thread.currentThread().getPriority());
    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println(Thread.currentThread().getName()+" : "+i);
        }
    }
}