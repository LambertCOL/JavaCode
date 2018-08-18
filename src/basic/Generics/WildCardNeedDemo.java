package basic.Generics;

/**
 * @ProjectName: JavaCode
 * @Package: basic
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/13 11:08
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/13 11:08
 * 泛型学习
 */
public class WildCardNeedDemo {
    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);

        System.out.println("The max number is " + max(intStack));
    }

    public static double max(GenericStack<? extends Number> stack) {
        double max = stack.pop().doubleValue();

        while (!stack.isEmpty()) {
            double value = stack.pop().doubleValue();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

}
