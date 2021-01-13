package classloader;

public class Test {
    public static void main(String[] args) {
        // 此时并不会进行子类的初始化
         System.out.println(ChildrenOne.age);
        ChildrenOne[] childrenOnes = new ChildrenOne[8];
        ChildrenOne childrenOne = new ChildrenOne();
    }
}
