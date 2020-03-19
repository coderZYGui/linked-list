package com.zy;

/**
 * Description: 链表实现
 *
 * @author zygui
 * @date 2020/3/19 21:22
 */
public class LinkedList<E> extends AbstractList<E> {

    // ===============================
    /*
        重点:
            重构了代码;
            1、通过抽取了一个接口List,可以解决ArrayList和LinkedList公共方法的问题,
                让两者都实现List接口,实现接口中的方法;

            2、但是通过在ArrayList和LinkedList中的重写接口方法,发现有部分方法实现相同;
                所以又抽取了AbstractList抽象类,这个类是用来存储两者共同方法(重写接口后的部分方法)的实现;
                也包括一些其他的相同方法(非接口方法)

            3、这样以来,我们将ArrayList和LinkedList都继承该抽象类,就可以使用抽象父类中的方法了;
                但是这样的话,它们首先是继承了抽象类,又实现了List接口;我们可以将抽象类来实现
                接口,它们只需要继承抽象类就可以了. 此时,抽象类也只是实现了List接口中的部分
                方法(两者的公共方法实现),ArrayList和LinkedList只需要实现其他的接口方法即可!
     */
    // ===============================

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
