package random.DesignPattern.Singleton;

import java.io.Serializable;

// Singleton class
public class Samosa implements Serializable, Cloneable {

    private static Samosa instance;

    private Samosa() {
        // Private constructor to prevent instantiation

        // to handle reflection
        if(instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static Samosa getSamosa() {
        if (instance == null) {
            instance = new Samosa();
        }
        return instance;
    }

    public void display() {
        System.out.println("Samosa is ready!");
    }

    // Implementing readResolve method to preserve singleton property during deserialization
    protected Object readResolve() {
        return getSamosa();
    }

    // Implementing clone method to prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        return getSamosa();
    }
}
