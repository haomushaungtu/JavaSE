package i_ioDemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
            file.createNewFile();
        }
        IODemo demo = new IODemo();
        demo.writeFile();
    }
    
    public void writeFile() {
        BufferedWriter writer = null;
        try {
            File file = new File("E:\\test\\abc.txt/bb.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new BufferedWriter(new FileWriter(file,true));
            
            for (int i = 0; i < 10; i++) {
                String line = "12";
                writer.append(line);
                writer.append("\n");
                writer.flush();
            }
            writer.close();
        } catch (Exception e) {
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
