package quickRun;

public class Check2 {
    public static void main(String[] args) {
        String s = "Kumar";
        Test t = () -> System.out.println("Vivek");
        t.show();
    }
}

@FunctionalInterface
interface Test {
    public void show();
}