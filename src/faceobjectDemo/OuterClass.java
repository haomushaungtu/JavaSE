package faceobjectDemo;

public class OuterClass {

    private String outerName;

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

    public void test() {
        InnerClass innerClass = new InnerClass();
        innerClass.getInfo("内部类");
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.test();
    }
}
