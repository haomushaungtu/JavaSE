package l_classloaderDemo.proxyDemo;

public class Test {
    public static void main(String[] args) {
        IDog target = new GunDog();
        IDog dog = (IDog) MyProxyFactory.getProxy(target);
        dog.getInfo();
        dog.run();

    }
}
