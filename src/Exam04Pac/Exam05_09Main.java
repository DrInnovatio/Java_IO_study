package Exam04Pac;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.nio.Buffer;
import java.util.*;
import java.io.*;
import javax.swing.border.Border;

class Person implements Serializable {
    private String name;
    private int age;
    public Person (String a, int b){
        name = a;
        age = b;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}

class FormSwing extends JFrame implements ActionListener{
    private Vector vc = new Vector();
    private Container con;
    private JTextArea jta = new JTextArea();

    private JScrollPane jsp = new JScrollPane(jta);

    private JLabel lb = new JLabel("Age : ", JLabel.RIGHT );
    private JLabel lb1 = new JLabel("Name : ", JLabel.RIGHT );

    private JTextField jtf = new JTextField();
    private JTextField jtf1 = new JTextField();

    private JButton jbt = new JButton("Check");
    private JButton jbt1 = new JButton("Add");
    private JButton jbt2 = new JButton("save");
    private JButton jbt3 = new JButton("open");

    private JFileChooser jfc = new JFileChooser();


    public FormSwing(){
        super("Unlimited Data");
        this.init();
        this.start();
        this.setSize(500, 400);
        this.setVisible(true);
    }

    private void init() {
        con = this.getContentPane();
        con.setLayout(new BorderLayout());
        con.add("Center", jsp);
        JPanel jp = new JPanel(new BorderLayout());
        JPanel jp1 = new JPanel(new GridLayout(2, 1));
        jp1.add(lb);
        jp1.add(lb1);
        jp.add("West", jp1);
        JPanel jp2 = new JPanel(new GridLayout(2, 1));
        jp2.add(jtf);
        jp2.add(jtf1);
        jp.add("Center", jp2);

        JPanel jp3 = new JPanel(new GridLayout(1,2));
        JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jp5 = new JPanel(new GridLayout(1,3 ));

        jp4.add(jbt);
        jp5.add(jbt1);
        jp5.add(jbt2);
        jp5.add(jbt3);
        jp3.add(jp4);
        jp3.add(jp5);
        jp.add("South", jp3);
        con.add("North", jp);
    }
    private void start() {
        jbt1.addActionListener(this);
        jbt.addActionListener(this);
        jbt2.addActionListener(this);
        jbt3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbt1){
            String name = jtf.getText().trim();
            int age = Integer.parseInt(jtf1.getText().trim());
            Person ps = new Person(name, age);
            vc.add(ps);
            jtf.setText("");
            jtf1.setText("");
            jtf.requestFocus();
        }
        else if(e.getSource() == jbt){
            jta.setText("");
            for(int i = 0; i < vc.size(); i++){
                Person imsi = (Person)vc.elementAt(i);
                jta.append("\n");
                jta.append(i + " th name is " + imsi.getName());
                jta.append(i + " th name is " + imsi.getAge());

            }
        }
        else if(e.getSource() == jbt2){
            jfc.showSaveDialog(this);
            File f = jfc.getSelectedFile();
            try{
                FileOutputStream fos = new FileOutputStream(f);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(vc);
                oos.close();
                bos.close();
                fos.close();
            }catch(IOException ee){}
            jta.setText("save completed");
        }
        else if(e.getSource() == jbt3){
            jfc.showOpenDialog(this);
            File f = jfc.getSelectedFile();
            try{
                FileInputStream fis = new FileInputStream(f);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
                vc.clear();
                vc = (Vector)ois.readObject();
                ois.close();
                bis.close();
                fis.close();
            }catch(IOException | ClassNotFoundException ee){}
            jta.setText("Loading completed");
        }
    }
}

public class Exam05_09Main {
    public static void main(String[] args) {
        FormSwing fs = new FormSwing();
    }
}
