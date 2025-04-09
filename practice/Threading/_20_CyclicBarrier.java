package practice.Threading;

import java.util.concurrent.*;

public class _20_CyclicBarrier {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("All tasks are submitted");
            }
        });

        for(int i=1;i<=3;i++) {
            service.execute(new Worker3(i, barrier));
        }

        service.shutdown();
//        try {
//            if (!service.awaitTermination(30, TimeUnit.SECONDS)) {
//                service.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            service.shutdownNow();
//        }
    }
}

class Worker3 implements Runnable {

    private int id;
    CyclicBarrier barrier;

    public Worker3(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("Thread with id "+id+" started");
        try {
            Thread.sleep(3000);
            barrier.await();
            System.out.println("Thread with id " + id + " passed the barrier");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread with id "+id+" finished");
    }
}
