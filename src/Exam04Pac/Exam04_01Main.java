package Exam04Pac;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Exam04_01Main {

    public static void main(String[] args) throws IOException {
//        FilterOutputStream fos = new FilterOutputStream(System.out);
//        fos.write("How are you?".getBytes());
//        fos.flush();
        System.out.write("Hello".getBytes(StandardCharsets.UTF_8));
    }
}
