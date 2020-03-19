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
                实际上,动态数组ArrayList和链表LinkedList有很多方法都是一样的,
            这时候可以为它们抽取一个父类List,父类中定义这些公共的方法;但是又
            发现,它们对这些方法的实现都不相同;所以抽取父类也就没有任何意义;
                此时,可以抽取一个接口,来定义这些方法,让它们来实现接口,重写接口
            方法;
                定义接口后,面向接口编程!
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
        return 0;
    }

    @Override
    public boolean inEmpty() {
        return false;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public void add(E element) {

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


}
