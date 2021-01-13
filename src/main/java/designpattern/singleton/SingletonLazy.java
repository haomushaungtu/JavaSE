package designpattern.singleton;

/**
 * 设计模式-01单例模式
 * 懒汉模式实现单例
 * 通过私有化构造器以及对外提供静态工厂方法保证了创建实例的限制及唯一的获取方式。
 * 在单线程时，饿汉模式没有问题
 * 多线程情形下，饿汉模式对实例判空时可能会出现
 * 线程1进行singleton判空处理时，此时线程2也在进行singleton判空处理时，这时就会出现singleton被实例化两次的情形，
 * 这与我们的单例的目的相悖，为了避免这种情形的发生，我们可以采用对getInstance()方法进行同步加锁
 */
public class SingletonLazy {


    /**
     * 定义实例变量 采用懒汉模式
     **/
    private static SingletonLazy singleton;

    /**
     * 私有化构造器
     **/
    private SingletonLazy() {

    }

    /**
     * 使用静态工厂方法，提供获取单例方法
     **/
    public static SingletonLazy getInstance() {
        if (singleton == null) {
            singleton = new SingletonLazy();
        }
        return singleton;
    }
}