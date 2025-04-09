package practice.Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _15_Executor_FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i=0;i<10;i++) {
            executor.execute(new Execute(i));
        }

        executor.shutdown();
    }
}

class Task implements Runnable {

    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Executing thread id: " + id + " from thread: " + Thread.currentThread().getName() + " thread-id:" + Thread.currentThread().getId());
        try {
            TimeUnit.MILLISECONDS.sleep((long) Math.random() * 5);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
