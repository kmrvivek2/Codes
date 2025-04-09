package practice.Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _14_Executor_SingleThread {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++) {
            executor.execute(new Execute(i));
        }

        executor.shutdown();
    }
}

class Execute implements Runnable {

    private int id;

    public Execute(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Executing thread id: "+id+" from thread: "+Thread.currentThread().getName()+" thread-id:"+Thread.currentThread().getId());
        try{
            TimeUnit.MILLISECONDS.sleep((long) Math.random()*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}