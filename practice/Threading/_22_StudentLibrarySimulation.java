package practice.Threading;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _22_StudentLibrarySimulation {
    public static void main(String[] args) {
        Student[] students = null;
        Book[] books = null;
        ExecutorService service = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);

        try {
            students = new Student[Constants.NUMBER_OF_STUDENTS];
            books = new Book[Constants.NUMBER_OF_BOOKS];

            for(int i=0;i<Constants.NUMBER_OF_BOOKS;i++)
                books[i] = new Book(i+1);

            for(int i=0;i<Constants.NUMBER_OF_STUDENTS;i++) {
                students[i] = new Student(i+1, books);
                service.execute(students[i]);
            }

            Thread.sleep(Constants.TIME_OUT);

            for(Student student : students)
                student.setDone(true);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}

class Constants {
    private Constants() {
    }

    public static final int NUMBER_OF_STUDENTS = 2;
    public static final int NUMBER_OF_BOOKS = 3;
    public static final long TIME_OUT = 5*1000;
}

class Book {
    private int id;
    private Lock lock;

    public Book(int id) {
        this.id = id;
        lock = new ReentrantLock();
    }

    public void read(Student student) throws InterruptedException {
        if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
            System.out.println(student + " is reading " + this);
            Thread.sleep(2000);
            lock.unlock();
            System.out.println(student + " has finished reading " + this);
        }
    }

    @Override
    public String toString() {
        return "Book id-"+ id;
    }
}

class Student implements Runnable {
    private int id;
    private Book[] books;
    private Random random;
    private boolean done;

    public Student(int id, Book[] books) {
        this.id = id;
        this.books = books;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true && !done) {
            int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);
            try {
                books[bookId].read(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Student #id-"+ id;
    }
}