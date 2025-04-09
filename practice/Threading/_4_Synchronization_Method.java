package practice.Threading;

/*
Note:
    -> There are processes and Thread (light-weight processes).
    -> The typical difference is that thread (of the same process) run in a shared memory space
        while processes run in separate memory spaces.
    -> Every Thread has its own STACK memory but
        all threads share the HEAP memory (Shared memory space).
    -> The main purpose of Synchronization is the sharing of resources
        without interference using mutual exclusion.
    -> Because object has a single lock, this is why the multiple methods
        can not be executed at the same time.
    -> Class level Lock vs Object level Lock:
        -> If we have a static method, then it will have a class level lock.
        -> If we have a non-static method, then it will have an object level lock.

Challenges of synchronization in Java, focusing on the synchronized keyword.
Here's a breakdown of the key points:

Synchronized Method:
The synchronized method ensures that only one thread can execute it at a time
by acquiring a lock (intrinsic lock or monitor lock) associated with the object.

Performance Issues:
The instructor illustrates this with examples of two independent methods
that increment separate counters.
Even though these methods are independent,
if they're synchronized, they cannot be executed simultaneously,
leading to potential performance drawbacks.

Object-Level vs. Class-Level Locking:

Object-Level Locking:
This occurs when a synchronized method is called on an instance of a class.

Class-Level Locking:
This is used for static methods, where the lock is associated with the class itself.

Best Practices:
Using synchronized blocks is often better than synchronizing entire methods,
as it provides more control over which parts of the code need to be thread-safe.

Future Discussions:
By setting the stage for addressing class-level locking issues
in the next session.

Overall, the lecture covers the mechanics of locks,
the performance implications of synchronization,
and the differences between object-level and class-level locking.

*/

public class _4_Synchronization_Method {

    public static int counter = 0;

    // we have to make sure this method is executed only by one thread at a time
    // It need to be consistent -> That only thread access this method at a time
    public static synchronized void increment() {
        counter++;
    }

    // Usually it is not a good practice to synchronize the whole method
        public static void increase() {
            // This block of code is synchronized
            synchronized (_4_Synchronization_Method.class) {
                counter++;
            }
        }

        public void increment2() {
            // This block of code is synchronized
            synchronized (this) {
                counter++;
            }
        }

    public static void process() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++)
                    // Below line gives the wrong result sometime, because it is not a atomic process
                    counter++;
                    //increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++)
                    // Below line gives the wrong result sometime, because it is not a atomic process
                    counter++;
                    //increment();
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The counter is: "+counter);
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        process();
        long end = System.currentTimeMillis();
        System.out.println("Time taken: "+(end-start)+" ms");
    }
}
