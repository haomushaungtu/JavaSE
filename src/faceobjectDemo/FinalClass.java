package faceobjectDemo;

/**
 * 关于final关键字的运用</br>
 * 1.final修饰变量时，必须由程序员显示指定初始值</br>
 * 2.类成员变量用final修饰时，初始化值必须在声明变量时赋值，或者在静态代码块中对类成员变量赋值</br>
 * 3.实例变量时，必须在声明，非静态代码块，构造器中赋值 </br>
 * 4.final引用基本数据类型时不能被改变，引用对象地址不能被改变，但是引用对象可以被改变</br>
 * 5.宏定义作用，编译期确定值</br>
 * 
 * @author huanghao
 *
 */
public class FinalClass {
    // 定义一个类变量
    private static final String field;
    private final int age;
    static {
        field = "";
    }

    {
        this.age = 6;
    }

    public FinalClass(int age) {
    }

    public FinalClass() {

    }

}
