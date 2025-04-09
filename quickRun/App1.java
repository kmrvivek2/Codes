package quickRun;

/*

 */

import java.lang.reflect.Field;
import java.util.HashMap;

public class App1 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        try {
            Field loadFactorField = HashMap.class.getDeclaredField("loadFactor");
            loadFactorField.setAccessible(true);
            float loadFactor = (float) loadFactorField.get(map);
            System.out.println("Load Factor: " + loadFactor);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
