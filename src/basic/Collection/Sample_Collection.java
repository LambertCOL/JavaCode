package basic.Collection;

import java.util.*;

/**
 * @ProjectName: JavaCode
 * @Package: basic.Collection
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/13 17:40
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/13 17:40
 */
public class Sample_Collection {
    public static void main(String[] args) {
        //set
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("3");
        System.out.println("hashSet:" + hashSet);
        //list
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(3);
        System.out.println("arrayList:" + arrayList);
        //Stack
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('c');
        stack.push('e');
        stack.push('g');
        System.out.println("stack:\n\t" + stack.size());
        while (!stack.isEmpty()) {
            System.out.print("\t"+stack.pop());
        }
        System.out.println("\n\t" + stack.size());
        //Queue
        Queue<String> queue = new PriorityQueue();
        queue.add("abc");
        queue.add("def");
        queue.add("ghi");
        System.out.println(queue);
    }
}
