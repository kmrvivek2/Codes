package quickRun;

public class TryCatchFinallyExp {
    public static void main(String[] args) {
        System.out.println(checkTest());
    }

    /**
     Key Points:

     Bytecode Generation:
     When the Java compiler encounters a finally block,
     it generates bytecode to ensure that the finally block is executed regardless of how the try or catch
     blocks are exited (normal execution, return, or exception).

     JVM Execution:
     The JVM ensures that the finally block is executed by inserting the corresponding bytecode
     instructions into the control flow of the program.

     Behavior of return in finally:
     If a return statement exists in the finally block,
     it overrides any return statement in the try or catch blocks.
     This is because the finally block is executed last, and its return statement takes precedence.

     Conclusion:
     The finally block's behavior is implemented in the JVM and enforced through bytecode instructions.
     The return in the finally block takes precedence because it is executed last in the control flow.
     This behavior is not implemented in Java packages but is part of the Java language and JVM design

    **/

    public static int checkTest() {
        try {
            System.out.println("Try block executed");
            return 5;
            //throw new Exception("An exception occurred");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
            return 1;
        }
        finally {
            System.out.println("Finally block executed");
            return 2;
        }
    }
}
