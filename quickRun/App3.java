package quickRun;

import java.io.IOException;
import java.io.UncheckedIOException;

public class App3 {
    public static void main(String[] args) {
        UncheckedIOException e = new UncheckedIOException(new IOException("UncheckedIOException occurred"));
        System.out.println(e.getMessage());

        //Exception
    }
}
