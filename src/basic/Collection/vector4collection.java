package basic.Collection;

import java.util.Enumeration;
import java.util.Stack;
import java.util.Vector;

/**
 * @ProjectName: JavaCode
 * @Package: basic.Collection
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/15 10:45
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/15 10:45
 */
public class vector4collection {
    public static void main(String[] args) {
        Vector vector1 = new Vector();//创建一个初始容量为10的向量，当元素数超过初始容量，容量就会自动增加“默认容量”个容量
        vector1.add(1);
        vector1.add(2);
        vector1.add(3);
        vector1.add(4);
        vector1.add(5);
        vector1.add(6);
        vector1.add(7);
        vector1.add(8);
        vector1.add(9);
        vector1.add(10);//到此为止向向量添加了10个元素，默认容量已经满了
        System.out.println("capacity : " + vector1.capacity() + " vector1 : " + vector1);
        vector1.add(11);//再添加一个元素，超出了初始容量，则新容量=原容量+默认容量：newCapacity = oldCapacity + capacity
        System.out.println("capacity : " + vector1.capacity() + " vector1 : " + vector1);



        Vector vector2 = new Vector(3, 2);//创建一个初始容量为3，增量为2的向量，当元素数超过初始容量，容量就会自动增加“增量”个容量
        vector2.add(1);
        vector2.add(2);
        vector2.add(3);//到此为止向向量添加了3个元素，默认容量已经满了
        System.out.println("capacity : " + vector2.capacity() + " vector2 : " + vector2);
        vector2.add(4);//再添加一个元素，超出了初始容量，则新容量=原容量+增量：newCapacity = oldCapacity + increment
        System.out.println("capacity : " + vector2.capacity() + " vector2 : " + vector2);

        
        
        Object[] intArr = new Object[vector2.capacity()];
        vector2.copyInto(intArr);
        System.out.print("length : " + intArr.length + " intArr : " );
        for (int i = 0; i < intArr.length; i++) {
            System.out.print(intArr[i]+" ");
        }
        System.out.println();
        
        
        
        System.out.println("index:3 in vector1 : "+vector1.elementAt(3));
        System.out.println("index:2 in vector2 : "+vector2.elementAt(2));
        


        Enumeration e = vector1.elements();
        System.out.print("iterate enumeration : ");
        while (e.hasMoreElements()){
            System.out.print(e.nextElement()+" ");
        }

        System.out.println();
        System.out.println("reset vector1's size to 8");
        vector1.setSize(8);
        System.out.println("capacity : " + vector1.capacity());

        Stack s = new Stack();
        s.push(11);
        s.push(12);
        s.push(13);
        s.push(14);
        s.push(15);
        System.out.println("stack : "+s);
        s.pop();
        s.remove(2);
        System.out.println("stack that pop once and remove element which index 2 : "+s);
        System.out.println("stack size : "+s.size());
        System.out.println("stack capacity : "+s.capacity());
    }
}
