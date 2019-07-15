package b_basicClassLibraryDemo;

import java.io.IOException;

/**
 * Runtime类的应用</br>
 * 
 * @see Runtime </br>
 * @author huanghao
 *
 */
public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
        System.out.println(rt.freeMemory());
        rt.exec("Notepad.exe");
    }
}
