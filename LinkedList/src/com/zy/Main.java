package com.zy;

/**
 * Description:
 *
 * @author zygui
 * @date 2020/3/19 22:00
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(0, 20);
        list.add(list.size(), 30);
        list.add(null);
        Integer remEle = list.remove(1);
        System.out.println("移除的元素:" + remEle);

        // list.clear();
        // list.remove(Integer.valueOf(30));
        Integer oldEle = list.set(0, 100);
        System.out.println("原来的元素: " + oldEle);

        int i = list.indexOf(null);
        System.out.println("null的位置:" + i);

        System.out.println(list); // [100, 30, null]
    }
}
