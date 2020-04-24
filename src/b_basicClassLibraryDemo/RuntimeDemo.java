package b_basicClassLibraryDemo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runtime类的应用</br>
 * 
 * @see Runtime </br>
 * @author huanghao
 *
 */
public class RuntimeDemo {
    /** 日志 **/
    private static Logger logger = LoggerFactory.getLogger(RuntimeDemo.class);

    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
        logger.info("当前空闲内存:[{}]", rt.freeMemory());
        rt.exec("Notepad.exe");
    }
}
