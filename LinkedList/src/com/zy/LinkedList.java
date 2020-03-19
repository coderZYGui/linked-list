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
            1、clear方法,size=0; first=null时,链表指向的第一个Node就为null,后面的
                所有结点没有引用了就会被释放,所以后面的结点都会被释放

            2、设计一个方法,传入一个index,返回该index的结点,通过first去寻找结点,看需要next几次,找到该结点;
                可以发现,next的次数和index有关系,index为几,就需要next几次

            3、完成 get、set方法
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
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        // 通过node方法找到结点,通过结点的element来获取元素
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        // 获取index处的结点
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        // 返回的是没覆盖之前的结点元素信息
        return oldElement;
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
     * 传入一个index,返回该index位置的结点对象
     * @param index
     * @return
     */
    private Node<E> node(int index){
        /*
            通过first去寻找结点,看需要next几次,找到该结点;
            可以发现,next的次数和index有关系,index为几,就需要next几次
         */
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
