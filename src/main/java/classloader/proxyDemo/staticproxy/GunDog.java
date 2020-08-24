package classloader.proxyDemo.staticproxy;

/**
 * 目标类
 * 
 * @author huanghao
 * @Date 2019-06-06 10:18
 */
public class GunDog implements IDog {

    @Override
    public void run() {
        System.out.println("跑");
    }

    @Override
    public void getInfo() {
        System.out.println("狗");
    }

}
