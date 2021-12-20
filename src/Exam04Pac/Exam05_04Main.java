package Exam04Pac;

import java.io.*;

class Test1 implements Serializable{
    double x;
    int a;
    short y;
}

public class Exam05_04Main {

    public static void main(String[] args) {
        ObjectStreamClass osc = null;
        try{
            osc = ObjectStreamClass.lookup(Class.forName("Test1"));
        } catch (ClassNotFoundException e) {}

        assert osc != null;
        ObjectStreamField osf = osc.getField("y");
        System.out.println("Name = : " + osf.getName());
        System.out.println("Offset = : " + osf.getOffset());
        System.out.println("Type = : " + osf.getType());
        System.out.println("TypeCode = : " + osf.getTypeCode());
        System.out.println("TypeString = : " + osf.getTypeString());
    }

}


