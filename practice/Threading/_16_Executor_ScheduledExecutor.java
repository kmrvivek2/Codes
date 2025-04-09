package practice.Threading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _16_Executor_ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new StockMarketUpdate(), 1000, 2000, TimeUnit.MILLISECONDS);

        //executor.shutdown();
    }
}

class StockMarketUpdate implements Runnable{

    @Override
    public void run(){
        System.out.println("Updated price of stock");
    }
}