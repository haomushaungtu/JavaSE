package classloaderDemo;

import java.net.URL;

public class BootStrapClassLoaderTest {
    @SuppressWarnings("restriction")
    public static void main(String[] args) {
        // 获取根类加载器路径
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }
    }
}
