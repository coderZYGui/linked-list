package com.zy;

/**
 * Description: 定义动态数组和链表的公共接口
 *
 * @author zygui
 * @date 2020/3/19 21:50
 */
public interface List<E> {

    /**
     * 找不到元素返回-1
     */
    // 默认就是 public static final修饰
    int ELEMENT_NOT_FOUNT = -1;

    /**
     * 清除所有元素
     */
    void clear();

    /**
     * 元素的数量
     *
     * @return
     */
    int size();

    /**
     * 是否为空
     *
     * @return
     */
    boolean inEmpty();

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 添加元素到尾部
     *
     * @param element
     */
    void add(E element);

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素
     */
    E set(int index, E element);

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    void add(int index, E element);


    /**
     * 删除index位置的元素
     *
     * @param index
     * @return 被删除的元素
     */
    E remove(int index);

    /**
     * 删除传入的元素
     *
     * @param element
     */
    void remove(E element);

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    int indexOf(E element);
}
