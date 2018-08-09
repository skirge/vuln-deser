package sample0;

import java.io.*;
import java.util.Date;

/**
 * Created by skirge on 22.02.17.
 */
public class Sample0 {

    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        Person p = new Person();

        p.name = "John";
        p.surname = "Smith";
        p.birthDate = new Date();
        p.age = 33;

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("/tmp/person.bin"));
        oos.writeObject(p);
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("/tmp/person.bin"));
        Person p2 = (Person) ois.readObject();
        System.out.println("[*] Person read: " + p2);
    }
}
