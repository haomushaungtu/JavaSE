package designpattern.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghao
 */
public class TestProxy{
    public static void main(String[] args) throws Exception {
//        Class clazz = Proxy.getProxyClass(Prusit.class.getClassLoader(), Prusit.class);
//        Constructor constructor = clazz.getConstructor(InvocationHandler.class);
//        Prusit prusit = (Prusit)constructor.newInstance(new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
//        prusit.giveFloor();

        List list1 =new ArrayList();
        List list3 = new ArrayList();

        list1.add("1111");
        list1.add("2222");
        list1.add("3333");
        list1.add("4444");
        list1.add("5555");
        list3.addAll(list1);

        List list2 =new ArrayList();
        list2.add("3333");
        list2.add("4444");
        list2.add("666");



        list1.removeAll(list2); //差异集合，相差得元素

        System.out.println(list1.toString());
        System.out.println(list3.toString());
    }
}
