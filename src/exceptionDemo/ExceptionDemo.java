package exceptionDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 异常类
 * 
 * @see Exception </br>
 *      1.无论try catch语句， finally都会执行，即使有return语句 </br>
 *      2.catch finally可选，try必须存在，且try代码块中变量时局部变量</br>
 *      3.避免在finally中return 或者throw这会导致try，catch中return，throw失效</br>
 *      4.try中存在return时，会先执行存在的finally语句
 *      5.jdk7后可不用关闭资源,在try关键字后紧跟()括号中可以声明、初始化一个或多个资源，自动关闭必须显式关闭的资源</br>
 *      网络连接，数据库连接等资源
 * @author huanghao
 *
 */
public class ExceptionDemo {

    public static void main(String[] args) throws IOException {
        try (PrintStream pi = new PrintStream(new FileOutputStream("a.txt"))) {
            System.out.println();
        }
        // 隐式关闭资源
        try (OutputStream os = new FileOutputStream("")) {
        }
    }
}
