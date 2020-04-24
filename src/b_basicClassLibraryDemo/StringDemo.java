package b_basicClassLibraryDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * String类常用类 </br>
 * 1.不可改变类，一旦创建不可改变</br>
 * 2.由于是不可变类，hashcode值一经创建便缓存起来,不需要重新创建,作为hashmap的键,处理速度很快</br>
 * 3.final的String类实现字符串池,不可变的字符串常量都可以指向同一个字符串，节省heap空间</br>
 * 4.不可变类的String实现了多线程安全,同一个字符串实例可以被多个线程共享</br>
 * 
 * @see String
 * @author huanghao
 *
 */
public class StringDemo {

    /** 日志 **/
    private static Logger logger = LoggerFactory.getLogger(StringDemo.class);

    private final char value[];

    public StringDemo(char v[]) {
        this.value = v;
    }

    public void getSameObject() {
        value[0] = '2';
        String zeroString = "abc";
        logger.info("结果:[{}]", zeroString.intern());
        String zero2String = "abc";
        String oneString = new String("abc");
        String twoString = new String("abc");
        String threeString = new String("abcd");
        logger.info("结果:[{}]", oneString.equals(twoString));// true
        logger.info("结果:[{}]", oneString == twoString);// false
        logger.info("结果:[{}]", oneString == zeroString);// false
        logger.info("结果:[{}]", zero2String == zeroString);// true
        oneString = threeString;
        logger.info("结果:[{}]", oneString);
        logger.info("结果:[{}]", zeroString.codePointAt(1));
    }

    public static void main(String[] args) {
        char v[] = { 'a' };
        StringDemo demo = new StringDemo(v);
        logger.info("结果:[{}]", demo.value);
        demo.getSameObject();
        logger.info("结果:[{}]", demo.value);
    }
}
