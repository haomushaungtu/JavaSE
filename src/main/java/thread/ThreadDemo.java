package thread;

/**
 * 什么是线程:操作系统能够进行运算调度的最小单位，一条线程指的是进程中一个单一顺序的控制流<br>
 * 实现线程两种方式 继承Thread类 @see Thread </br>
 * 
 * @author huanghao
 * @Date 2019-07-06 15:20
 */
public class ThreadDemo extends Thread {

    public void run() {
        System.out.println("fsdg");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo demo = new ThreadDemo();
        System.out.println(Thread.currentThread().getName());
        demo.start();
        System.out.println(Thread.currentThread().getName());
        ThreadDemo.sleep(100);
    }
}
