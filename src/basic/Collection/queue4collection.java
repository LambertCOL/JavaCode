package basic.Collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ProjectName: JavaCode
 * @Package: basic.Collection
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/15 15:08
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/15 15:08
 */
public class queue4collection {
    public static void main(String[] args) {
        Queue queue1 = new LinkedList();
        queue1.offer(2);
        queue1.offer(22);
        queue1.offer(4);
        queue1.offer(44);
        queue1.offer(6);
        queue1.offer(66);
        printQueue(queue1);

        PriorityQueue queue2 = new PriorityQueue();
        queue2.offer("pie");
        queue2.offer("egg");
        queue2.offer("lemon");
        queue2.offer("apple");
        queue2.offer("mango");
        queue2.offer("banana");
        printQueue(queue2);

        PriorityQueue queue3 = new PriorityQueue(Collections.reverseOrder());
        queue3.offer("pie");
        queue3.offer("egg");
        queue3.offer("lemon");
        queue3.offer("apple");
        queue3.offer("mango");
        queue3.offer("banana");
        printQueue(queue3);

        PriorityQueue queue4 = new PriorityQueue();
        queue4.offer(43);
        queue4.offer(52);
        queue4.offer(12);
        queue4.offer(38);
        queue4.offer(65);
        queue4.offer(8);
        printQueue(queue4);


    }

    //输出队列
    public static void printQueue(Queue queue) {
        while (queue.size() > 0) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}
