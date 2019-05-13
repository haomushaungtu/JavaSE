package collectionDemo;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class DefineArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    private static final long serialVersionUID = 4409460913836361707L;
    /**
     * 默认初始化值
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空数组实例
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
