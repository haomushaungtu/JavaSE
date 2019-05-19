package collectionDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection 接口List
 * 
 * @author huanghao
 *
 */
public class MyDefineList {
    private List<String> upperList = new ArrayList<>();

    public void copyListMethod() {
        upperList.add("1");
        System.out.println(upperList.isEmpty());
    }

    public static void main(String[] args) {
        MyDefineList defineList = new MyDefineList();
        defineList.copyListMethod();
        List<String> list = new DefineArrayList<>();
        list.add("01010");
        System.out.println(list.toString());
    }
}
