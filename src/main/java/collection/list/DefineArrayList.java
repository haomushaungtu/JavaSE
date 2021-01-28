package collection.list;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/**
 * ArrayList 实现原理
 * @see java.util.ArrayList <br>
 * 1.底层原理为数组数据结构 elementData[] <br>
 * 2.添加元素方法原理:(1)计算当前需要扩充数组是否小于默认数组长度10,小于则直接扩充到10数组长度<br>
 * (2)首次添加元素后，数组长度直接被扩充到10长度 
 * 
 * @author huanghao
 *
 * @param <E>
 */
public class DefineArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    private static final long serialVersionUID = 4409460913836361707L;

    /**
     * 容器数组
     */
    transient Object[] elementData;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 修改次数
     */
    private int modCount;

    /**
     * 默认初始化值
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空数组实例
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /** 空元素数组 */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /** 最大数组长度 */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 1.7以前默认长度为10，现默认为空元素数组
     */
    public DefineArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 指定数组长度的构造方法
     * 
     * @param initialCapacity
     */
    public DefineArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    /**
     * 添加元素
     */
    public boolean add(E e) {
        // 确保容器大小大于增加元素后的容量大小
        ensureCapacityInternal(size + 1); // Increments modCount!!
        // 将增加元素放入数组容器中
        elementData[size++] = e;
        return true;
    }

    @Override
    public E get(int index) {
        // 检查是否数组越界
        rangeCheck(index);
        // 返回数组该索引位置元素
        return elementData(index);
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 扩充数组长度
     * 
     * @param minCapacity
     */
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    /**
     * 计算目前需要容量
     * 
     * @author huangaho
     * @param elementData
     * @param minCapacity
     * @return
     */
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        // 扩充容量小于默认值时，容量大小最小为默认值
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(minCapacity, DEFAULT_CAPACITY);
        }
        return minCapacity;
    }

    /**
     * 
     * @author huangaho
     * @params
     * @param minCapacity
     */
    public void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    /**
     * 扩容
     * 
     * @author huangaho
     * @see basic_numerical_class.Operators 操作符
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        // 新数组容量为旧数组的1.5倍
        int newCapacity = oldCapacity + oldCapacity >> 1;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 扩容超过一定值时，给予新增最大值数组
     * 
     * @author huangaho
     * @params
     * @param minCapacity
     * @return
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    /**
     * 判断当前索引下标是否超过数组大小
     * 
     * @param index
     */
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * 越界信息
     * 
     * @param index
     * @return
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    /**
     * 移除元素
     */
    public E remove(int index) {
        // 检查是否超过数组范围
        rangeCheck(index);
        modCount++;
        E oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null; // clear to let GC do its work
        return oldValue;
    }

    /**
     * 添加整个集合
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew); // Increments modCount
        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + numNew, numMoved);
        System.arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    /**
     * A version of rangeCheck used by add and addAll.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
}
