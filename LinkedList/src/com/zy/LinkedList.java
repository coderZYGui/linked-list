package com.zy;

/**
 * Description: 双向链表实现
 *
 * @author zygui
 * @date 2020/3/19 21:22
 */
public class LinkedList<E> extends AbstractList<E> {

    /**
     * 指向第一个结点
     */
    private Node<E> first;

    /**
     * 指向最后一个结点
     */
    private Node<E> last;


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

        // 指向上一个结点
        Node<E> prev;

        // 结点构造器
        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prev != null) {
                sb.append(prev.element);
            }
            sb.append("_").append(element).append("_");
            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }
            return sb.toString();
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
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

        rangeCheckForAdd(index);

        if (index == size) {    // 往最后添加元素
            Node<E> oldLast = last; // 之前的最后一个结点
            last = new Node<E>(oldLast, element, null);
            if (oldLast == null) {  // 这是链表添加的第一个元素
                // 此时链表的first,last都指向新结点
                first = last;
            } else {
                // 再将原来的last指向现在的last
                oldLast.next = last;
            }
        } else {
            // 获取当前要插入位置的结点
            Node<E> next = node(index);
            // 其上一个结点
            Node<E> prev = next.prev;
            // 创建一个新的结点(这个新结点的指向已经初始化好了)
            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;
            if (prev == null) { // index == 0
                // 也就是插入到第一个结点的位置
                first = node;
            } else {
                prev.next = node;
            }
        }
        size++;
    }

    @Override
    /**
     * 返回的是被删除元素的element
     */
    public E remove(int index) {
        rangeCheck(index);

        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) { // index == 0
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) { // index == size - 1
            last = prev;
        } else {
            next.prev = prev;
        }

        size--;
        return node.element;
    }

    @Override
    public void remove(E element) {
        remove(indexOf(element));
    }

    @Override
    /**
     * element是保存在node里的,传入element,返回该结点的索引
     */
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            // 因为element都在node中,所以通过next来遍历node
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUNT;
    }

    /**
     * 传入一个index,返回该index位置的结点对象
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        // 当传入非法index就会报异常
        rangeCheck(index);

        if (index < (size >> 1)) {
            /*
            通过first去寻找结点,看需要next几次,找到该结点;
            可以发现,next的次数和index有关系,index为几,就需要next几次
            */
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            /*
             从后往前找, 因为是双向链表;
             */
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public String toString() {
        // 打印格式: size=3, [10, 20, 30]
        // 使用StringBuilder 效率高一些
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            string.append(node.toString());
            if (i != size - 1) {
                string.append(", ");
            }
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
