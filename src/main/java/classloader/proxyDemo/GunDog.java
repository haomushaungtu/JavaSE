package classloader.proxyDemo;

/**
 * @author huanghao
 *
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
