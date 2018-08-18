package basic.Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: JavaCode
 * @Package: basic.Collection
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/14 8:47
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/14 8:47
 */
public class iterator4collection {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        list1.add("red");
        list1.add("yellow");
        list1.add("green");
        list2.add("red");
        list2.add("yellow");
        list2.add("blue");

//        a
        addAll(list1, list2);
//        b
//        list1.add(list2);
//        System.out.println(list1);//"red", "yellow", "blue", "red", "yellow", "green"
//        System.out.println(list2);//
//        c
//        c
        removeAll(list1, list2);
//        d
        remove(list1, list2);
//        e
        retainAll(list1,list2);
//        f
        list1.clear();
        System.out.println(list1);

    }

    private static void retainAll(List<String> list1, List<String> list2) {
        System.out.println("e.");
        list1.retainAll(list2);
        System.out.println(list1);//"red", "yellow", "green", "red", "yellow", "blue"
        System.out.println(list2);//"red", "yellow", "blue"
    }

    private static void remove(List<String> list1, List<String> list2) {
        System.out.println("d.");
        list1.remove(list2);
        System.out.println(list1);//"red", "yellow", "green", "red", "yellow", "blue"
        System.out.println(list2);//"red", "yellow", "blue"
    }

    private static void removeAll(List<String> list1, List<String> list2) {
        System.out.println("c.");
        list1.removeAll(list2);
        System.out.println(list1);//"red", "yellow", "green", "red", "yellow", "blue"
        System.out.println(list2);//"red", "yellow", "blue"
    }

    private static void addAll(List<String> list1, List<String> list2) {
        System.out.println("a.");
        list1.addAll(list2);
        System.out.println(list1);//"red", "yellow", "green", "red", "yellow", "blue"
        System.out.println(list2);//"red", "yellow", "blue"
    }
}
