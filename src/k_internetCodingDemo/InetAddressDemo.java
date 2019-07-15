package k_internetCodingDemo;

import java.io.IOException;
import java.net.InetAddress;

/**
 * ip地址类
 * @author huanghao
 *
 */
public class InetAddressDemo {
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        System.out.println("测试是否可达" + ip.isReachable(2000));
        System.out.println(ip.getHostAddress());
        InetAddress local = InetAddress.getByAddress(new byte[] { 127, 0, 0, 1 });
        System.out.println(local.isReachable(5000));
        System.out.println(local.getCanonicalHostName());
    }
}
