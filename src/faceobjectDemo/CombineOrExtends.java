package faceobjectDemo;

/**
 * 对于继承和复用之间优缺点</br>
 * 子类继承父类可进行代码复用
 * 
 * @author huanghao
 *
 */
public class CombineOrExtends extends AbstractPerson {

    public AbstractPerson person;

    public CombineOrExtends(AbstractPerson person) {
        this.person = person;
    }

    public static void main(String args[]) {
        AbstractPerson person1 = new AbstractPerson();
        CombineOrExtends ex = new CombineOrExtends(person1);
        System.out.println(ex.height);
    }
}
