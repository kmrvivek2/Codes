package practice.Threading;

/*

Because the intrinsic lock is released, the second thread is able to acquire the intrinsic lock and run

this synchronized block.

So this is why we print out consume method is executed.

And because it could notify, what does it mean that it is going to notify waiting thread that it can

continue with the execution of the synchronized block.

So it is going to print out again in the producer method.

So what's crucial that the notify is going to notify the threads that are in a waiting state that they

can again acquire the intrinsic lock, which means that they can carry on with the execution of a given

synchronize block.

What's crucial that this notify - it is not going to handle the lock immediately.

We can make further operations.

So after calling the notify method, if we do something here, for example, just for demonstration

purposes, we are going to wait for 5 seconds.

So if I save and run it, running the produce method consume method is executed.

And as you can see, we wait for 5 seconds before printing out again in the producer method.

So it is crucial that after the notify method, Java is going to execute the other parts of the code

until it finishes with the synchronized block, and then it is going to notify the thread in a waiting

state that okay, you are free to execute other parts of the synchronized block.

This is the crucial part.

*/

public class _6_Notify_Wait {
    public static void main(String[] args) {
        Process process = new Process();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}

class Process{
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Produce is running...");
            wait(); // Release Intensive lock
            System.out.println("Produce is resumed...");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("Consume is running...");
            notify(); // Notify the waiting thread to continue waiting for the lock
            Thread.sleep(3000);
            System.out.println("Consume is resumed...");
        }
    }
}
