package sample2;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by skirge on 19.01.17.
 */

public class Handler2 implements InvocationHandler,
        Serializable {

    public Object invoke(Object proxy, Method method,
                         Object[] args)
            throws IOException {

        System.out.println("[*] Handler2.invoke method called with args:\n" +
                "method = [" + method + "],\n" +
                "args=[" + Arrays.toString(args) + "]");
        // something stupid here!
        Runtime.getRuntime().exec((String) args[0]);
        System.out.println("[*] Handler2.invoke end");
        return this;
    }
}



