package practice.Threading;

public class _1_join {
    public static void main(String[] args) {
        Thread t1 = new Thread(new NormalClass(),"Thread 1");
        Thread t2 = new Thread(new NormalClass(),"Thread 2");

        t1.start();
        t2.start();

        // We can wait for the threads to complete using join method
        try {
            t1.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Below line is executed only after t1 is completed because we have t1.join() above
        System.out.println("Finished with Thread");
    }
}

class NormalClass implements Runnable {

    @Override
    public void run() {
        for (int i=1;i<=5;i++)
            System.out.println(Thread.currentThread().getName() + " : " + i);
    }
}
