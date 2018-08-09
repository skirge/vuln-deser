package sample2;

import java.io.*;
import java.util.Map;

/**
 * Created by skirge on 19.01.17.
 */

public class Gadget2 implements Serializable,
        Externalizable {
    public Map map;
    public String key;
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("[*] writeExternal method called");
        out.writeObject(map);
        out.writeObject(key);
        System.out.println("[*] writeExternal end");

    }
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        System.out.println("[*] readExternal method called");
        map = (Map) in.readObject();
        key = (String) in.readObject();
        // Nothing stupid here for sure!
        String foo = (String) map.get(key);
        System.out.println("[+]\tfoo = " + foo);
        System.out.println("[*] readExternal end");
    }
}
