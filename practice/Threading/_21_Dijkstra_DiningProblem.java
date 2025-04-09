package practice.Threading;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _21_Dijkstra_DiningProblem {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = null;
        Philosopher[] philosophers = null;
        Fork[] forks = null;

        try {
            philosophers = new Philosopher[Constant.PHILOSPHER];
            forks = new Fork[Constant.FORK];

            for(int i=0;i<Constant.FORK;i++) {
                forks[i] = new Fork(i);
            }

            service = Executors.newFixedThreadPool(Constant.PHILOSPHER);
            for (int i=0;i<Constant.PHILOSPHER;i++) {
                philosophers[i] = new Philosopher(i, forks[i], forks[(i+1)%Constant.PHILOSPHER]);
                service.execute(philosophers[i]);
            }

            Thread.sleep(Constant.TIMEOUT);

            for (Philosopher p: philosophers) {
                p.setFull(true);
            }
        } finally {
            service.shutdown();

            while(!service.isTerminated())
                Thread.sleep(1000);

            for (Philosopher p: philosophers) {
                System.out.println("Philosopher "+p+" ate "+p.getEatingCounter()+" times");
            }
        }

        try {
            Thread.sleep(Constant.TIMEOUT);
            for (Philosopher p: philosophers) {
                p.setFull(true);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Constant {
    public static final long EATING_TIME = 1000;
    public static final int PHILOSPHER = 5;
    public static final int FORK = 5;
    public static final long TIMEOUT = 5*1000;

    private Constant() {

    }
}

enum State {
    RIGHT, LEFT;
}

class Philosopher implements Runnable {
    private int id;
    private Fork leftFork;
    private Fork rightFork;
    private int eatingCounter;

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    private volatile boolean full;
    private Random random;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.random = new Random();
    }

    @Override
    public void run() {
        try{
            while (!full) {
                think();
                if (leftFork.pickUp(this, State.LEFT)) {
                    if (rightFork.pickUp(this, State.RIGHT)) {
                        eat();
                        rightFork.putDown(this, State.RIGHT);
                    }
                    leftFork.putDown(this, State.LEFT);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void think() throws InterruptedException {
        System.out.println(this+" is thinking...");
        Thread.sleep(random.nextInt(1000));
    }

    private void eat() throws InterruptedException {
        System.out.println(this+" is eating...");
        eatingCounter++;
        Thread.sleep(random.nextInt(1000));
    }

    public int getEatingCounter(){
        return eatingCounter;
    }

    public String toString() {
        return "Philosopher-"+id;
    }
}

class Fork {
    private int id;
    private Lock lock;

    public Fork(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean pickUp(Philosopher p, State state) throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println(p+" picked up "+state+" fork "+this);
            return true;
        }

        return false;
    }

    public void putDown(Philosopher p, State state) {
        lock.unlock();
        System.out.println(p+" put down "+state+" fork "+this);
    }

    public String toString() {
        return "Fork-"+id;
    }
}