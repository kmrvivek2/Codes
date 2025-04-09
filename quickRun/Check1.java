package quickRun;

import java.util.Map;
import java.util.HashMap;

public class Check1 {
    public static void main(String[] args) {
        Map<String, String> ma = new HashMap<String, String>();

        for(Map.Entry en : ma.entrySet()) {
            System.out.println("Key"+en.getKey()+" value"+en.getValue());
        }
    }
}