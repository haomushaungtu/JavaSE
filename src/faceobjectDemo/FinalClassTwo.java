package faceobjectDemo;

/**
 * 对于一个不可变类的缓存</br>
 * 
 * @author huanghao
 *
 */
public final class FinalClassTwo {
    private static final int MAX_SIZE = 10;
    private static int pos = 0;
    private static FinalClassTwo[] finalClassTwo = new FinalClassTwo[MAX_SIZE];
    private String name;

    private FinalClassTwo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static FinalClassTwo valueOf(String name) {
        for (int i = 0; i <= MAX_SIZE; i++) {
            if (finalClassTwo[i] != null && finalClassTwo[i].getName().equals(name)) {
                return finalClassTwo[i];
            }
        }
        if (pos == MAX_SIZE) {
            finalClassTwo[0] = new FinalClassTwo(name);
            pos = 1;
        } else {
            finalClassTwo[pos++] = new FinalClassTwo(name);
        }
        return finalClassTwo[pos - 1];
    }
}
