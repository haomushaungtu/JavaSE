package classloader;

public class MyParent {
    static {
        System.out.println("Hello world this is myparent");
    }
    protected String length;

    protected static int age = 123;
}
