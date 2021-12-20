package Exam03Pac;

import java.io.*;

public class Exam03_10 extends FileWriter {

    public Exam03_10(){
        super(FileDescriptor.out);
    }

    public Exam03_10(File f) throws FileNotFoundException, IOException {
        super(f);
    }

    public Exam03_10(File f, boolean b) throws FileNotFoundException, IOException {
        super(f, b);
    }
    public Exam03_10(FileDescriptor fd){
        super(fd);
    }

    public Exam03_10(String str) throws FileNotFoundException, IOException {
        super(str);
    }

    public Exam03_10(String str, boolean b) throws FileNotFoundException, IOException {
        super(str, b);
    }


}
