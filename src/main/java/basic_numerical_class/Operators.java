package basic_numerical_class;

/**
 * 操作符说明
 * 按位与 &,逻辑与 &&
 * 按位或|,逻辑与 || 短路与否判断是否需要继续
 * <<和>> 有符号左移和右移(左移乘以2的n次方，右移除以2的n次方)
 * <<<和>>> 无符号左移和右移
 * ~取反操作
 * ^异或
 * @author huanghao
 * @Date 2019-10-08 15:12
 */
public class Operators {
    public static void main(String[] args) {
        int numberA = -15;
        int numberB = -5;
        System.out.println(numberA >> 1);
        System.out.println(numberA >> 2);
        System.out.println(numberA << 1);
        System.out.println(numberB >>> 2);
        System.out.println(numberB >> 1);
    }
}
