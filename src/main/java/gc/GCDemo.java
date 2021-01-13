package gc;

import java.util.ArrayList;
import java.util.List;

/**
 * GC ROOTS可作为对象为
 * 1.虚拟机栈（栈帧中的本地变量表）中引用的对象 ?
 * 2.方法区中类静态属性引用的对象
 * 3.方法区中常量引用的对象
 * 4.本地方法栈中JNI(native方法)引用的对象
 * GC收集器
 * serial单线程收集器 适合新生代复制算法高效,需要stop the word
 * parNew多线程收集器 serial多线程版本，唯一可与cms匹配的新生代收集器
 * parallel Scavenge 新生代多线程收集器，采用复制算法,注重吞吐量
 * serial old老年代版本,标记整理算法
 * parallel old收集器，与parallel scavenge新生代收集器配合使用，标记整理算法
 * cms收集器，与用户线程并发执行。初始标记stop the world 并发标记->重新标记 stop the world->并发清除
 * 初始标记:GC ROOTS能直接关联到的对象
 * 并发标记:跟踪GC ROOTS
 * 重新标记:标记那些程序运行期间标记发生变化的记录
 * 并发清除:清除那些带有标记的内存
 * 内存回收关键字:
 * ParOldGen 老年代采用parallel old收集器
 * PSYoungGen 新生代采用parallel scavenge
 * par new generation 新生代采用parNew收集器
 * concurrent mark-sweep generation 老年代采用cms收集器
 * -XX:+UseConcMarkSweepGC ->parnew + cms
 * -XX:+UseParallelGC   ->parallel scavange + parallel old
 */
public class GCDemo {

    private static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    private static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> objects = new ArrayList<>();
        for (int i=0;i < num;i++) {
            Thread.sleep(500);
            objects.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
