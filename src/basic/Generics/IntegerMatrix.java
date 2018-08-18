package basic.Generics;

/**
 * @ProjectName: JavaCode
 * @Package: basic.Generics
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/13 14:55
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/13 14:55
 */
public class IntegerMatrix extends GeneralizedMatrix<Integer> {
    @Override
    protected Integer add(Integer o1, Integer o2) {
        return o1 + o2;
    }

    @Override
    protected Integer multiply(Integer o1, Integer o2) {
        return o1 * o2;
    }

    @Override
    protected Integer zero() {
        return 0;
    }
}
