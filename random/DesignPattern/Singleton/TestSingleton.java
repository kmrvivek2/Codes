package random.DesignPattern.Singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingleton {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException, CloneNotSupportedException {

        TestSingleton tS = new TestSingleton();
        //tS.testGeneral();
        //tS.testThreadSafe();
        //tS.testAPIReflection();
        //tS.testSerializeDeserialize();
        tS.testClone();
    }

    /**
     * Test the Singleton pattern
     * This method demonstrates the Singleton pattern by creating two instances of the Samosa class
     * and checking if they are the same instance.
     */
    private void testGeneral() {
        // Get the single instance of Samosa
        Samosa samosa1 = Samosa.getSamosa();
        Samosa samosa2 = Samosa.getSamosa();

        // Display the message
        samosa1.display();

        // Check if both instances are the same
        System.out.println("samosa1 hashcode: " + samosa1.hashCode());
        System.out.println("samosa2 hashcode: " + samosa2.hashCode());
        if (samosa1 == samosa2) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }
    }

    /**
     * Test the Singleton pattern in a multi-threaded environment
     * This method demonstrates the Singleton pattern by creating multiple threads
     * and checking if they all get the same instance of the Samosa class.
     * Return same instance of Samosa class --> until we throw exception in Constructor
     */
    private void testThreadSafe() {
        // Create multiple threads to test the Singleton pattern
        Thread thread1 = new Thread(() -> {
            Samosa samosa = Samosa.getSamosa();
            System.out.println("Thread 1: " + samosa.hashCode());
        });

        Thread thread2 = new Thread(() -> {
            Samosa samosa = Samosa.getSamosa();
            System.out.println("Thread 2: " + samosa.hashCode());
        });

        thread1.start();
        thread2.start();
    }

    /**
     * Test the Singleton pattern using reflection
     * This method demonstrates the Singleton pattern by using reflection to create a new instance
     * of the Samosa class and checking if it is the same instance as the original.
     * This will throw an error as we are throwing error in constructor
     */
    private void testAPIReflection() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Samosa s1 = Samosa.getSamosa();
        System.out.println("samosa1 hashcode: " + s1.hashCode());

        // Use reflection to create a new instance of Samosa
        Constructor<Samosa> constructor = Samosa.class.getDeclaredConstructor();
        constructor.setAccessible(true); // Allow access to the private constructor
        Samosa s2 = constructor.newInstance(); // Throw error as we are throwing error in constructor
        System.out.println("samosa2 hashcode: " + s2.hashCode());
    }

    /**
     * Test the Singleton pattern using serialization and deserialization
     * This method demonstrates the Singleton pattern by serializing and deserializing
     * the Samosa class and checking if it is the same instance as the original.
     * This will throw an error as we are throwing error in constructor
     */
    private void testSerializeDeserialize() throws IOException, ClassNotFoundException {
        Samosa s1 = Samosa.getSamosa();
        System.out.println("samosa1 hashcode: " + s1.hashCode());

        // Serialize the instance
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("samosa.ser"));
        oos.writeObject(s1);

        // Deserialize the instance
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("samosa.ser"));
        Samosa s2 = (Samosa) ois.readObject();
        System.out.println("samosa2 hashcode: " + s2.hashCode());

        // Check if the serialization & deserialized instance is the same as the original
        Samosa s3 = Samosa.getSamosa();
        System.out.println("samosa3 hashcode: " + s3.hashCode());
        oos.writeObject(s3);
        Samosa s4 = (Samosa) ois.readObject();
        System.out.println("samosa4 hashcode: " + s4.hashCode());
    }

    private void testClone() throws CloneNotSupportedException {
        Samosa s1 = Samosa.getSamosa();
        System.out.println("samosa1 hashcode: " + s1.hashCode());

        // Clone the instance
        Samosa s2 = (Samosa) s1.clone();
        System.out.println("samosa2 hashcode: " + s2.hashCode());

        // Check if the cloned instance is the same as the original
        if (s1 == s2) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }
    }
}
