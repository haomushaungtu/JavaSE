package designpattern.singleton;

/**
 * 设计模式-01单例模式
 * 内部类实现单例
 * 通过私有化构造器以及对外提供静态工厂方法保证了创建实例的限制及唯一的获取方式。
 * 由于在类加载过程中，外部类加载时内部类并不会随着外部类加载而加载，只有在调用内部类方法或者属性时才会进行内部类的加载。
 * 由此可以借由内部类实现单例模式
 */
public class SingletonStaticClass {

    /** 私有化构造器 **/
    private SingletonStaticClass(){

    }

    private static class InnerClass{
        private  final static SingletonStaticClass instance = new SingletonStaticClass();

    }

    /** 使用静态工厂方法，提供获取单例方法 **/
    public  static SingletonStaticClass getInstance() {
        return  InnerClass.instance;
    }
}
