package basic.Generics;

import java.util.ArrayList;

/**
 * @ProjectName: JavaCode
 * @Package: basic.Generics
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/13 16:34
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/13 16:34
 */
public class Exercise {
    public static void main(String[] args) {
        test19_8();
    }

    //    19.3
    public static void test19_3() {
        ArrayList<String> sList = new ArrayList<>();
        sList.add("a");
        sList.add("b");
        sList.add("b");
        ArrayList<Integer> iList = new ArrayList<>();
        iList.add(1);
        iList.add(2);
        iList.add(2);
        ArrayList<Character> cList = new ArrayList<>();
        cList.add('d');
        cList.add('d');
        cList.add('e');
        sList = removeDuplicates(sList);
        iList = removeDuplicates(iList);
        cList = removeDuplicates(cList);
        for (String s : sList) {
            System.out.print(s + "\t");
        }
        for (Integer i : iList) {
            System.out.print(i + "\t");
        }
        for (Character c : cList) {
            System.out.print(c + "\t");
        }
    }

    //    19.3.返回一个新ArrayList，新的列表中包含来自原列表中的不重复元素
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            E element = list.get(i);
            if (!resultList.contains(element)) {
                resultList.add(element);
            }
        }
        return resultList;
    }

    //    19.8
    public static void test19_8() {
        ArrayList<String> sList = new ArrayList<>();
        sList.add("a");
        sList.add("b");
        sList.add("c");
        sList.add("d");
        sList.add("e");
        for (String s : sList) {
            System.out.print(s + "\t");
        }
        System.out.println();
        sList = shuffle(sList);
        for (String s : sList) {
            System.out.print(s + "\t");
        }
    }

    //    19.8.打乱ArrayList
    public static <E> ArrayList<E> shuffle(ArrayList<E> list) {
        ArrayList<E> resultList = new ArrayList<>(list.size());
        while (!list.isEmpty()) {
            E e = list.get((int) (Math.random() * list.size()));
            resultList.add(e);
            list.remove(e);
        }
        return resultList;
    }


}
