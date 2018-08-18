package basic.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: JavaCode
 * @Package: basic.Collection
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/14 17:55
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/14 17:55
 */
public class staticMethodInCollectons {
    public static List list = Arrays.asList(1, 34, 26, 58, 92, 63, 41, 8, 12, 18);
    public static List listString = Arrays.asList("banana", "apple", "cherry", "fig", "date");
    public static List list1 = Arrays.asList(1, 3, 5, 7, 9);
    public static List list2 = Arrays.asList(2, 4, 6, 8, 10);
    public static List list3 = Arrays.asList(2, 4, 6);

    public staticMethodInCollectons() {


    }

    public static void SORT(List list) {
        SEPARATOR();
        Collections.sort(list);
        System.out.println("list after sort : " + list);
    }

    public static void SORT(Object[] array) {
        SEPARATOR();
        Arrays.sort(array);
        System.out.print("array after sort : ");
        for (String s:(String[])array) {
            System.out.print(s+"\t");
        }
        System.out.println();
    }

    public static void SORTwithCOMPARATOR() {
        SEPARATOR();
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("list after sort with reverseOrder : " + list);
    }

    public static void BINARYSEARCH() {
        SEPARATOR();
        Collections.sort(list);
        System.out.println("binarySearch result : " + list + "|" + Collections.binarySearch(list, 34));
    }

    public static void REVERSE() {
        SEPARATOR();
        Collections.reverse(list);
        System.out.println("list after reverse : " + list);
    }

    public static void SHUFFLE() {
        SEPARATOR();
        Collections.shuffle(list);
        System.out.println("list after shuffle : " + list);
    }

    public static void COPY(List src, List tag) {
        SEPARATOR();
        System.out.println("src before copy : " + src);
        System.out.println("tag before copy : " + tag);
        Collections.copy(src, tag);
        System.out.println("src after copy : " + src);
        System.out.println("tag after copy : " + tag);
    }

    public static void NCOPIES(int count, Object o) {
        SEPARATOR();
        list = Collections.nCopies(count, o);
        System.out.println("list after nCopies : ");
        for (Object a : list) {
            for (int n : (int[]) a) {
                System.out.print(n);
            }
            System.out.println();
        }
    }

    public static void FILL() {
        SEPARATOR();
        ArrayList newList = new ArrayList(list);
        Collections.fill(newList, new int[]{4, 5, 6});
        System.out.println("newList after fill : ");
        for (Object o:newList) {
            for (int i:(int[])o){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    private static void SEPARATOR() {
        System.out.println("====================");
    }

    public static void main(String[] args) {
        SORT(list);
        SORT(listString);
        SORT(new String[]{"banana", "apple", "cherry", "fig", "date"});
        SORTwithCOMPARATOR();
        BINARYSEARCH();
        REVERSE();
        SHUFFLE();
        COPY(list1, list3);
        COPY(list1, list2);
        NCOPIES(5, new int[]{1, 2, 3});
        FILL();
    }
}
