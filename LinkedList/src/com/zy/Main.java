package com.zy;

/**
 * Description:
 *
 * @author zygui
 * @date 2020/3/19 22:00
 */
public class Main {
    public static void main(String[] args) {
        // testList(new ArrayList<>());
        // testList(new DoubleLinkedList<>());
        // testList(new SingleCircleLinkedList<>());
        testList(new DoubleCircleLinkedList<>());
    }

    static void testList(List<Integer> list){
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]

        list.remove(0); // [11, 66, 22, 33, 44, 77]
        list.remove(2); // [11, 66, 33, 44, 77]
        list.remove(list.size() - 1); // [11, 66, 33, 44]

        System.out.println(list);

        AssertUtil.test(list.indexOf(44) == 3);
        AssertUtil.test(list.indexOf(22) == List.ELEMENT_NOT_FOUNT);
        AssertUtil.test(list.contains(33));
        AssertUtil.test(list.get(0) == 11);
        AssertUtil.test(list.get(1) == 66);
        AssertUtil.test(list.get(list.size() - 1) == 44);
    }
}
