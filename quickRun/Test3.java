package quickRun;

public class Test3 {

    private static Test3 instance = new Test3();
    private Test3(){}
    public static Test3 getInstance(){
        return instance;
    }
}
