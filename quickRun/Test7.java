package quickRun;

public class Test7 {
    public static void main(String[] args) {
        int a = 2, b = 3;

        System.out.println("a :"+a+" b :"+b+" a^b :" + (a^b));
        a = a^b;
        System.out.println("a :"+a+" b :"+b+" a^b :" + (a^b));
        b = a^b;
        System.out.println("a :"+a+" b :"+b+" a^b :" + (a^b));
        a = a^b;
        System.out.println("a :"+a+" b :"+b+" a^b :" + (a^b));
    }
}
