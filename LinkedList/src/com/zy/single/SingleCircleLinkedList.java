package com.zy.single;

import com.zy.AbstractList;

/**
 * Description: 单向循环链表实现
 *
 * @author zygui
 * @date 2020/3/19 21:22
 */
public class SingleCircleLinkedList<E> extends AbstractList<E> {

    /*
        单向循环链表, 相对于单链表; 我们只需要更高 add、remove方法即可!
     */

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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(element).append("_").append(next.element);
            return sb.toString();
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
        rangeCheckForAdd(index);

        // 当index传0的时候,就会报异常,此时要特殊处理
        if (index == 0) {
            Node<E> newFirst = new Node<>(element, first);

            // 拿到最后一个结点; 判断只有一个结点的情况
            Node<E> last = (size == 0) ? newFirst : node(size - 1);
            // 最后一个结点的next指向头结点
            last.next = newFirst;
            first = newFirst;

        } else {
            // 在index处插入元素,首先要找到它前面的结点
            Node<E> preNode = node(index - 1);
            // 让前面的结点的next指向新创建的结点,新创建的结点指向index处的结点即可
            // 此时index处的结点,就是它前面的结点的next,就是指向index处的结点
            Node<E> newNode = new Node<>(element, preNode.next);
            // 前面的结点的next再指向新的结点
            preNode.next = newNode;
        }
        size++;
    }

    @Override
    /**
     * 返回的是被删除元素的element
     */
    public E remove(int index) {
        // 假如被删除的结点为第一个结点
        Node<E> node = first;
        if (index == 0) {
            if (size == 1) { // 链表中只有一个元素的时候
                first = null;
            } else {
                Node<E> last = node(size - 1);
                // first已经指向了第一个结点,如果要删除第一个结点,此时要将first指向第一个结点的next结点
                first = first.next;
                last.next = first; // 最后一个结点指向新的第一个结点
            }
        } else {
            Node<E> preNode = node(index - 1);
            node = preNode.next; // 这个node就是当前被删除的结点
            //preNode.next = preNode.next.next;
            preNode.next = node.next;
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
