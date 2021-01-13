package designpattern.singleton;

/**
 * 设计模式-01单例模式
 * 饿汉模式实现单例
 * 通过私有化构造器以及对外提供静态工厂方法保证了创建实例的限制及唯一的获取方式。
 * 由于在类加载的同时也会加载实例对象，饿汉模式初始加载时会消耗更多的内存资源，降低系统加载速度
 */
public class SingletonHungry {

    /** 定义实例变量 采用饿汉模式 即在类加载时就行类实例的初始化**/
    private static final SingletonHungry singleton = new SingletonHungry();

    /** 私有化构造器 **/
    private SingletonHungry(){

    }

    /** 使用静态工厂方法，提供获取单例方法 **/
    public static SingletonHungry getInstance() {
        return  singleton;
    }
}
