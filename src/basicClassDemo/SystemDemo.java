package basicClassDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * System类的应用</br>
 * 
 * @see System
 * 
 * @author huanghao
 *
 */
public class SystemDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties prps = System.getProperties();
        prps.store(new FileOutputStream("prps.txt"), "System propreties");
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.currentTimeMillis());
    }
}
