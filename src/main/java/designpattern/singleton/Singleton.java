package designpattern.singleton;

/**
 * 设计模式-01单例模式
 * 通过私有化构造器以及对外提供静态工厂方法保证了创建实例的限制及唯一的获取方式。
 * 双重加锁检查，保证线程安全同时，最大化地利用了系统资源
 * 对于创建实例对象过程中存在的指令重排序问题，
 * 我们需要使用volatile关键字对待实例化对象进行修饰，这是因为在实例化对象即singleton = new Singleton()过程中，JVM执行了3步指令
 * 1.给singleton对象分配内存 2.调用Singleton的构造函数，初始化形成实例 3.将singleton对象指向对应内存空间
 * 单线程情形下，执行顺序无论是1->3->2还是1->2->3,获取到实例结果相同但是在多线程情形下，
 * 在线程1,2执行时可能会出现线程1执行1->3->2顺序时在执行到第3步分配内存空间时，线程2执行判空处理，
 * 发现当前instance不为空，直接返回instance，但是此时的instance并没进行第2步进行初始化对象，从而出现错误，
 * 所以使用volatile关键字对实例化过程进行限制，避免出现未完成实例化过程时，
 * 有线程对instance对象进行读操作（此处为instance判空处理）
 */
public class Singleton {

    /** 定义实例变量 采用懒汉模式 volatile防止指令重排序 **/
    private volatile static Singleton singleton;

    /** 私有化构造器 **/
    private Singleton(){

    }

    /** 使用静态工厂方法，提供获取单例方法，采用双重校验锁方式 **/
    public  static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return  singleton;
    }
}
