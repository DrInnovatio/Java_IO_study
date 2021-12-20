package Exam03Pac;

import java.io.File;

public class Exam03_01Main {

    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = new Integer(5);

        System.out.println("a, b  = " + a.compareTo(b));

        File ff = new File("aaa.txt");
        System.out.println(ff);
    }
}

// Method : compareTo(Object)


