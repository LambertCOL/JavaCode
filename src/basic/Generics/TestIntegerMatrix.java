package basic.Generics;

/**
 * @ProjectName: JavaCode
 * @Package: basic.Generics
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/13 14:56
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/13 14:56
 */
public class TestIntegerMatrix {
    public static void main(String[] args) {
        Integer[][] m1 = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {1, 1, 1}};
        Integer[][] m2 = new Integer[][]{{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};
        IntegerMatrix integerMatrix = new IntegerMatrix();
        System.out.println("\nm1 + m2 is ");
        GeneralizedMatrix.printResult(m1, m2, integerMatrix.addMatrix(m1, m2), '+');
        System.out.println("\nm1 * m2 is ");
        GeneralizedMatrix.printResult(m1, m2, integerMatrix.mutiplyMatrix(m1, m2), '*');
    }
}
