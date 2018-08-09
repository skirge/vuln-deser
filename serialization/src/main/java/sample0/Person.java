package sample0;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by skirge on 22.02.17.
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 0x12345678L;
    public String name;
    public String surname;
    public Date birthDate;
    public transient int age;

}
