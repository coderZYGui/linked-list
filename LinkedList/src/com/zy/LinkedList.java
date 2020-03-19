package com.zy;

/**
 * Description: 链表实现
 *
 * @author zygui
 * @date 2020/3/19 21:22
 */
public class LinkedList<E> implements List<E> {

    // ===============================
    /*
        重点:
            可以发现有些方法的实现是和ArrayList相同的,可以将这些
            公共的抽取出来;

     */
    // ===============================

    /**
     * 元素(结点)的数量
     */
    private int size;

    /**
     * 指向第一个结点
     */
    private Node<E> first;

    /**
     * 找不到元素返回-1
     */
    private static final int ELEMENT_NOT_FOUNT = -1;

    /**
     * 结点类;为链表的内部类
     *
     * @param <E>
     */
    private static class Node<E> {

        //存储元素的信息
        E element;

        //指向下一个结点
        Node<E> next;

        // 结点构造器
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean inEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUNT;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public void remove(E element) {

    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    /**
     * 封装数组越界异常
     *
     * @param index
     */
    private void indexOutOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    /**
     * 检查get,remove传入的index是否有效
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            indexOutOfBounds(index);
        }
    }

    /**
     * 根据index插入元素时,判断index是否有效
     *
     * @param index
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            indexOutOfBounds(index);
        }
    }
}
