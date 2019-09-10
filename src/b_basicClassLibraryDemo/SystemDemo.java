package b_basicClassLibraryDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * System类的应用</br>
 * 
 * @see System
 * 
 * @author huanghao
 *
 */
public class SystemDemo {

    public void getMessage() throws ConfigurationException {
        Configurations config = new Configurations();
        XMLConfiguration xmlConfig = new XMLConfiguration();
        xmlConfig = config.xml("src/b_basicClassLibraryDemo/jdbc.xml");
        String abs = xmlConfig.getString("db_user");
        System.out.println(abs);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ConfigurationException {
        Properties prps = System.getProperties();
        prps.store(new FileOutputStream("prps.txt"), "System propreties");
        FileInputStream ins = new FileInputStream(new File("src/b_basicClassLibraryDemo/jdbc.xml"));
        prps.loadFromXML(ins);
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.currentTimeMillis());
        SystemDemo demo = new SystemDemo();
        demo.getMessage();
    }
}
