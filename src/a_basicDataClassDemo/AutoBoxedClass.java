package a_basicDataClassDemo;

/**
 * 自动装箱类
 * 
 * @author huanghao
 *
 */
public class AutoBoxedClass {
    private int numberA = 9;

    public void ToBoxed() {
        System.out.println(Integer.toString(numberA, 2));
        Integer numberC = 63;
        System.out.println(Integer.toString(numberC, 16));
    }

    public static void main(String[] args) {
        AutoBoxedClass boxedClass = new AutoBoxedClass();
        boxedClass.ToBoxed();
    }
}
