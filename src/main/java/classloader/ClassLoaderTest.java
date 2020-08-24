package classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 1.根类加载器并不是java实现的</br>
 * 2.系统类加载器的父类加载器是扩展类加载器</br>
 * 3.扩展类加载器的父类实际是根类加载器，但其getParent()方法获取不到根类加载器 </br>
 * 
 * @author huanghao
 *
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws IOException {
        // 获取系统类加载器
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器: " + systemLoader);
        /*
         * 获取系统类加载器的加载路径--通常是由CLASSPATH环境变量指定的 </br>
         * 如果操作系统没有指定CLASSPATH环境变量，则默认当前路径为系统类的加载路径 </br>
         */
        Enumeration<URL> eml = systemLoader.getResources("");
        while (eml.hasMoreElements()) {
            System.out.println(eml.nextElement());
        }
        // 获取系统类加载器的父类加载器，得到扩展类加载器
        ClassLoader extensionLoader = systemLoader.getParent();
        System.out.println("扩展类加载器: " + extensionLoader);
        System.out.println("扩展类加载器的加载路径:" + System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载器的父类加载器:" + extensionLoader.getParent());
    }
}
