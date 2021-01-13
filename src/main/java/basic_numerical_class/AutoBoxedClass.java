package basic_numerical_class;

/**
 * 自动装箱类
 * Integer类: 当自动装箱时缓存integer数组对象,默认缓存范围为-128~127,可通过
 * 注意到Integer a = 127 和 Integer b = new Integer(127); a!=b因为a为自动装箱时,调用Integer.valurof()方法
 * 而b为实例化开辟了一块新内存地址。与装箱时的缓存地址不相等
 *
 *
 * @author huanghao
 */
public class AutoBoxedClass {

    public static void main(String[] args) {
        Integer one = 128;
        Integer two = 128;
        Integer aaa = new Integer(-127);
        Integer three = -127;
        Integer four = -127;
        System.out.println(one == two);
        System.out.println(three == four);
        System.out.println(three == aaa);
        System.out.println(2<<2);
    }
}
