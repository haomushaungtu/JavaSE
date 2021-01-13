package designpattern.singleton;

/**
 * 设计模式-01单例模式
 * 枚举实现单例
 * 通过私有化构造器以及对外提供静态工厂方法保证了创建实例的限制及唯一的获取方式。
 * 由于枚举只会被加载一次而且是线程安全的，所以还可以采用枚举实现单例模式，注意到枚举类的构造器默认且必须private修饰
 */
public class SingletonByEnum {

    /** 私有化构造器 **/
    private SingletonByEnum(){

    }

    /**
     * 枚举类
     */
    private enum SingletonEnum{

        INSTANCE;

        private final SingletonByEnum instance;

        SingletonEnum(){
            instance = new SingletonByEnum();
        }

        private SingletonByEnum getInstance(){
            return instance;
        }
    }

    /**
     * 使用静态工厂方法，提供获取单例方法
     */
    public  static SingletonByEnum getInstance() {
        return  SingletonEnum.INSTANCE.getInstance();
    }
}
