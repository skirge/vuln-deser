package sample1;

import java.io.*;

/**
 * Created by skirge on 16.02.17.
 */
public class Gadget1 implements Serializable,
        Externalizable {
    public String cmd;
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("[*] writeExternal method called");
        out.writeObject(cmd);
        System.out.println("[*] writeExternal end");

    }
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        System.out.println("[*] readExternal method called");
        cmd = (String) in.readObject();
        // very stupid thing to do!
        Runtime.getRuntime().exec(cmd);
        System.out.println("[*] readExternal end");
    }
}
