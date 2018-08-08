package lambert.demo;

import java.util.Scanner;

/**
 * 【8.5练习】
 * <p>
 * 2.企业发放的奖金根据利润提成。
 * 利润(I)低于或等于10万元时，奖金可提10%；
 * 利润在10万元到20万元之间时，低于10万元的部分按10%提成，高于10万元的部分可提成7.5%；
 * 利润在20万元到40万元之间时，高于20万元的部分可提成5%；
 * 利润在40万元到60万元之间时，高于40万元的部分可提成3%；
 * 利润在60万元到100万元之间时，高于60万元的部分可提成1.5%；
 * 利润高于100万元时，超过100万元的部分按1%提成。
 * 从键盘输入当月利润I，求应发放奖金总数？
 * <p>
 * 3.一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
 */
public class _0805 {
    //         1.有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？请输出所有符合要求的数字
    public void solution1() {
        int count = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (i != j && i != k && j != k) {
                        count++;
                        System.out.print(i + "" + j + "" + k + "\t");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("总共" + count + "个数");
    }

    //         2.企业发放的奖金根据利润提成。
//            * 利润(I)低于或等于10万元时，奖金可提10%；
//            * 利润在10万元到20万元之间时，低于10万元的部分按10%提成，高于10万元的部分可提成7.5%；
//            * 利润在20万元到40万元之间时，高于20万元的部分可提成5%；
//            * 利润在40万元到60万元之间时，高于40万元的部分可提成3%；
//            * 利润在60万元到100万元之间时，高于60万元的部分可提成1.5%；
//            * 利润高于100万元时，超过100万元的部分按1%提成。
//            * 从键盘输入当月利润I，求应发放奖金总数？
    public static void solution2() {
        System.out.println("方法1");
        System.out.println("请输入当月利润：(万元)");
        double profit = new Scanner(System.in).nextDouble();
        System.out.println("本月利润为：" + profit + "万元");
        double bonus = 0;
        long t, time = System.currentTimeMillis();
        if (profit <= 10) {
            bonus += profit * 0.1;
        } else if (profit > 10 && profit <= 20) {
            bonus += (profit - 10) * 0.075 + 1;
        } else if (profit > 20 && profit <= 40) {
            bonus += (profit - 20) * 0.05 + (profit - 10) * 0.075 + 1;
        } else if (profit > 40 && profit <= 60) {
            bonus += (profit - 40) * 0.03 + (profit - 20) * 0.05 + (profit - 10) * 0.075 + 1;
        } else if (profit > 60 && profit <= 100) {
            bonus += (profit - 60) * 0.015 + (profit - 40) * 0.03 + (profit - 20) * 0.05 + (profit - 10) * 0.075 + 1;
        } else {
            bonus += (profit - 100) * 0.01 + (profit - 60) * 0.015 + (profit - 40) * 0.03 + (profit - 20) * 0.05 + (profit - 10) * 0.075 + 1;
        }
        System.out.println("本月奖金为" + bonus + "万元");
        System.out.println("time:" + (System.currentTimeMillis() - time) + "ms");
    }

    public static void solution2_1() {
        System.out.println("方法2");
        System.out.println("请输入当月利润：(万元)");
        double profit = new Scanner(System.in).nextDouble();
        System.out.println("本月利润为：" + profit + "万元");
        double bonus = 0;
        long t, time = System.currentTimeMillis();
        if (profit > 10) {
            bonus += (profit - 10) * 0.075 + 1;
            if (profit > 20) {
                bonus += (profit - 20) * 0.05;
                if (profit > 40) {
                    bonus += (profit - 40) * 0.03;
                    if (profit > 60) {
                        bonus += (profit - 60) * 0.015;
                        if (profit > 100) {
                            bonus += (profit - 100) * 0.01;
                        }
                    }
                }
            }
        } else {
            bonus += profit * 0.1;
        }
        System.out.println("本月奖金为" + bonus + "万元");
        System.out.println("time:" + (System.currentTimeMillis() - time) + "ms");
    }

    //    3.一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
    public static void solution3() {
        int p = 10, n = -1;
        long time = System.currentTimeMillis();
        for (; n > -268; n--) {
            if (Math.sqrt((n + 100)) * 10 % 10 == 0 && Math.sqrt((n + 268)) * 10 % 10 == 0) {
                System.out.println(n);
            }
        }
        for (; p < 9999999; p++) {
            if (Math.sqrt((p + 100)) * 10 % 10 == 0 && Math.sqrt((p + 268)) * 10 % 10 == 0) {
                System.out.println(p);
            }
        }
        System.out.println(System.currentTimeMillis() - time + "毫秒");
    }

    public static void main(String[] args) {
        solution3();
    }
}
