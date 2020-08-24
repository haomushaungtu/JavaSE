package thread;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 异步线程，定时延时轮询
 * @author huanghao
 *
 */
public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println("=======最外层======");
        final ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(1);
        scheduled.scheduleAtFixedRate(new Runnable() {
            public void run() {
                int i = 0;
                System.out.println(new Date());
                System.out.println("循环====" + i++);
            }
        }, 0, 10, TimeUnit.SECONDS);
    }
}