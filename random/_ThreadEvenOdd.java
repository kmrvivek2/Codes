package random;

public class _ThreadEvenOdd {

    public static void main(String[] args) {
        EvenOddPrinter printer = new EvenOddPrinter(10);

        Thread t1 = new Thread(printer::printEven, "EvenThread");
        Thread t2 = new Thread(printer::printOdd, "OddThread");

        t1.start();
        t2.start();
    }
}

class EvenOddPrinter {

    private final int max;
    private int number = 1;
    private final Object lock = new Object();

    public EvenOddPrinter(int max) {
        this.max = max;
    }

    public void printEven() {
        synchronized (lock) {
            while (number <= max) {
                if (number % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " - " + number);
                    number++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void printOdd() {
        synchronized (lock) {
            while (number <= max) {
                if (number % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + " - " + number);
                    number++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}