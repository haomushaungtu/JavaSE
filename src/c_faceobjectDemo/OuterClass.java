package c_faceobjectDemo;

/**
 * 内部类的应用 </br>
 * 1.实现建造者模式 <br>
 * 2.内部类单例模式实现线程安全<br>
 * 
 * @author huanghao
 *
 */
public class OuterClass {

    private String outerName;

    /**
     * 静态内部类</br>
     * 作为类成员
     * 
     * @author huanghao
     *
     */
    private static class InnerClass {
        private double weight;
        private String innerName;

        public InnerClass() {
        }

        public InnerClass(double weight, String innerName) {
            this.weight = weight;
            this.innerName = innerName;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public String getInnerName() {
            return innerName;
        }

        public void setInnerName(String innerName) {
            this.innerName = innerName;
        }

        public void getInfo(String innerName) {
            System.out.println("内部类名称为" + innerName);
            OuterClass out = new OuterClass();
            System.out.println("" + out.getOuterName());
        }
    }

    public String getOuterName() {
        return outerName;
    }

    public void setOuterName(String outerName) {
        this.outerName = outerName;
    }

    public static InnerClass builder() {
        InnerClass innerClass = new InnerClass();
        return innerClass;
    }
    
    public static void main(String[] args) {
        OuterClass.builder().getWeight();
    }
}
