package practice.Threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _19_Latch {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        CountDownLatch latch = new CountDownLatch(5);

        for(int i=1;i<=5;i++) {
            service.execute(new Worker2(i, latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdown();
        System.out.println("All tasks are submitted");
    }
}

class Worker2 implements Runnable {
    private int id;
    private CountDownLatch latch;

    public Worker2(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Thread with id "+id+" started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}
