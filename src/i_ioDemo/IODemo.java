package i_ioDemo;

import java.io.File;
import java.io.IOException;

/**
 * io流
 * 
 * @see InputStream</br>
 * @see OutputStream</br>
 * @author huanghao 
 *
 */
public class IODemo {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\test\\abc.txt");
        if (!file.exists()) {
            file.mkdirs();
            //file.createNewFile();
        }
//        FileOutputStream os = new FileOutputStream(file);
//        os.write("ok".getBytes());
//        os.close();
    }
}
