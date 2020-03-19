package com.zy;

/**
 * Description: 该类不对外公开,只是为了抽取一些公共的代码
 *
 * @author zygui
 * @date 2020/3/19 22:13
 */
/*
        抽象类是不能被实例化的，所以没有要求实现所有的方法。但是没写出的方法还是隐式的存在的。
    当你在定义一个非abstract类继承那个类的话，就一定要全部实现了。
 */
public abstract class AbstractList<E> implements List<E> {

    /**
     * 元素的数量
     */
    protected int size;

    /**
     * 元素的数量
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean inEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {
        // 如果element元素可以找到
        return indexOf(element) != ELEMENT_NOT_FOUNT;
    }

    /**
     * 添加元素到尾部
     *
     * @param element
     */
    public void add(E element) {
        // elements[size++] = element;
        // 传入数组数量(相当于在最后插入元素)
        add(size, element);
    }

    /**
     * 封装数组越界异常
     *
     * @param index
     */
    protected void indexOutOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    /**
     * 检查get,remove传入的index是否有效
     *
     * @param index
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            indexOutOfBounds(index);
        }
    }

    /**
     * 根据index插入元素时,判断index是否有效
     *
     * @param index
     */
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            indexOutOfBounds(index);
        }
    }
}
