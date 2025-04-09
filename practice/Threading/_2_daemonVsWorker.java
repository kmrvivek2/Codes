package practice.Threading;

public class _2_daemonVsWorker {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DaemonClass(),"Daemon Thread");
        Thread t2 = new Thread(new WorkerClass(),"Worker Thread");

        // Setting t1 as daemon thread
        t1.setDaemon(true);

        t1.start();
        t2.start();

        // Below line is executed first because t1 & t2 are running in parallel
        System.out.println("Finished with Thread");
    }
}

class DaemonClass implements Runnable {

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("DaemonClass Thread is running...");
        }
    }
}

class WorkerClass implements Runnable {

    @Override
    public void run() {
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished with Worker Thread");
    }
}