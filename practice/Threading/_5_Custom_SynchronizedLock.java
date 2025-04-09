package practice.Threading;

/*

We have been talking about the synchronized locks,
but basically we haven't solved the issue we have
been facing as far as executing independent operations are concerned.

So what's crucial that if we want to execute,
given the methods independently with the help of multiple threats, of course,
we cannot use the intrinsic lock of the object or the class because there is just
a single intrinsic lock associated with a given object or class in Java.

So what can be the solution?
We can create private static final object for lock1 is equals to a new object.
It doesn't need to be static, but because we are dealing with static methods.

This is why we have to make it static as well.
So it is going to be the first look.
And of course, we can create an independent object for the second lock.

And if we synchronize on that first lock and
then we synchronize on the second lock, so lock2

In this case, we have two independent counter variables and we have two independent methods.
And because we have instantiated two independent objects, we can use them as independent locks.

Lock1 is going to lock on the first method and the second lock is going to lock on the second method.

So if we save and run the application, it is going to be the same.

So basically, it is working fine.

The counter1 is a hundred, the counter2 is 100, so it is working fine.

But there's a crucial difference that here we have created our custom object for locking the given

synchronized blocks

So in this synchronized block, we lock on the first lock.

So what does it mean?

The first thread is going to lock on the first object.

The second thread is going to lock on that second object we have instantiated here, which means that

they are not using the same intrinsic lock of the object or the class, which means, of course, that

they can execute these methods independently.

The first thread is going to execute increment one, and it doesn't have to wait for the second thread

finishing with the increment2 and vice versa.

The second thread can execute increment2 without waiting for the first thread to finish with

increment1 method.

So this is why it is extremely convenient to create final objects for different locks, because this

is how we can make sure that independent methods can be executed by independent threads at the same

time - at the same time is not equal to parallel execution.

I mean, that central processing unit is going to use time-slicing algorithm in order to deal with both

of the threads.

OK, so this is how we can use custom objects for locking.

*/

public class _5_Custom_SynchronizedLock {

    public static int counter1 = 0;
    public static int counter2 = 0;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void increment1() {
        synchronized (lock1) {
            counter1++;
        }
    }

    public static void increment2() {
        synchronized (lock2) {
            counter2++;
        }
    }

    public static void increment11() {
        synchronized (_5_Custom_SynchronizedLock.class) {
            counter1++;
        }
    }

    public static void increment22() {
        synchronized (_5_Custom_SynchronizedLock.class) {
            counter2++;
        }
    }

    public static void process1() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++)
                    increment1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++)
                    increment2();
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

        System.out.println("The counter1 is: "+counter1);
        System.out.println("The counter2 is: "+counter1);
    }

    public static void process2() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++)
                    increment11();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++)
                    increment22();
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

        System.out.println("The counter1 is: "+counter1);
        System.out.println("The counter2 is: "+counter1);
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        process2();
        long end = System.currentTimeMillis();
        System.out.println("Time taken: "+(end-start)+" ms");

        start = System.currentTimeMillis();
        process1();
        end = System.currentTimeMillis();
        System.out.println("Time taken: "+(end-start)+" ms");

        /*
            Output:
            The counter1 is: 1000
            The counter2 is: 1000
            Time taken: 4 ms
            The counter1 is: 2000
            The counter2 is: 2000
            Time taken: 1 ms
        */
    }
}
