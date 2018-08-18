package basic.Collection;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @ProjectName: JavaCode
 * @Package: basic.Collection
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/17 10:10
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/17 10:10
 */
public class Exercise {
    public static File recordFile;
    public static int wrapNum = 1;

    public static void main(String[] args) {
        new Exercise()._20_19();
    }

    //20.19************************************************************************************
    private void _20_19() {
        long time = System.currentTimeMillis();
        try {
            recordFile = new File("record4exercise20_19.txt");
            if (!recordFile.exists()) {
                recordFile.createNewFile();
            }
            FileWriter fw = new FileWriter(recordFile);
            fw.write("");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> SpadeMap = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(9);
            add(10);
            add(11);
            add(12);
            add(13);
        }};//黑桃
        ArrayList<Integer> HeartMap = new ArrayList<>(SpadeMap);//红心
        ArrayList<Integer> ClubMap = new ArrayList<>(SpadeMap);//梅花
        ArrayList<Integer> DiamondMap = new ArrayList<>(SpadeMap);//方块
        ArrayList<Character> operator = new ArrayList<Character>() {{
            add('+');
            add('-');
            add('*');
            add('/');
        }};

        int times = 0;
        int count = 0;

        for (int i = 1; i <= SpadeMap.size(); i++) {
            for (int j = 1; j <= HeartMap.size(); j++) {
                for (int k = 1; k <= ClubMap.size(); k++) {
                    for (int l = 1; l <= DiamondMap.size(); l++) {
                        times++;
                        for (int m = 0; m < operator.size(); m++) {
                            for (int n = 0; n < operator.size(); n++) {
                                for (int o = 0; o < operator.size(); o++) {
                                    if (calculate24(i, operator.get(m), j, operator.get(n), k, operator.get(o), l)) {
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("共有" + times + "种挑选次数");
        System.out.println("共有" + count + "种符合24点");
        System.out.println("成功几率为" + (double) count / times);
        System.out.println("耗时:" + (System.currentTimeMillis() - time) / 1000 + "s");
    }

    private static boolean calculate24(int num1, char op1, int num2, char op2, int num3, char op3, int num4) {
        String expression = "" + num1 + op1 + num2 + op2 + num3 + op3 + num4;
        int result = EvaluateExpression.evaluateExpression(expression);
        if (result == 24) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(recordFile, true));
                bw.write(expression + (expression.length() > 7 ? "\t" : "\t\t") + (wrapNum % 10 == 0 ? "\n" : ""));
                bw.flush();
                bw.close();
                wrapNum++;
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //20.14************************************************************************************
    private static void _20_14() {
        System.out.println("enter an expression in postfix notation : ");
        String expression = new Scanner(System.in).nextLine().replaceAll(" ", "");
        Stack stack = new Stack<>();
        String temp = "";
        //扫描
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) - '0' >= '0' && expression.charAt(i) - '0' <= '9') {//数字
                temp += expression.charAt(i);
            } else {
                temp += " " + expression.charAt(i) + " ";
            }
        }
        String[] tokens = temp.split(" ");

        //解析
        for (String token : tokens) {
            if (token.length() == 0) {
                continue;
            }
            if ("+-*/".contains(token)) {
                calculate(stack, token);
            } else if (token.charAt(0) > 48 && token.charAt(0) < 57) {
                stack.push(Integer.valueOf(token));
            }
        }
        System.out.println(stack.pop());
    }

    private static void calculate(Stack numsStack, String operator) {
        int num1 = (int) numsStack.pop();
        int num2 = (int) numsStack.pop();
        switch (operator) {
            case "+":
                numsStack.push(num2 + num1);
                break;
            case "-":
                numsStack.push(num2 - num1);
                break;
            case "*":
                numsStack.push(num2 * num1);
                break;
            case "/":
                numsStack.push(num2 / num1);
                break;
        }
    }


    //20.9*************************************************************************************
    private static void _20_9() {
        System.out.println("generate 9 numbers randomly : ");
        Stack<Double> stack = new Stack<>();
        Stack<Double> tempStack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            double number = (double) Math.round(Math.random() * 10000) / 100;
            System.out.print(number + "  ");

            //遍历stack，如果栈顶大于新数，pop出加入到tempStack，否则直接入栈
            while (!stack.empty()) {
                if ((stack.peek()) > number) {
                    tempStack.push(stack.pop());
                    continue;
                }
                stack.push(number);
                break;
            }

            if (stack.empty()) {
                stack.push(number);
            }

            //遍历tempStack，取回tempStack的数重新放回stack
            while (!tempStack.empty()) {
                stack.push(tempStack.pop());
            }

        }
        System.out.println("\nstacking order : ");
        while (!stack.empty()) {
            System.out.print(stack.pop() + "  ");
        }
        System.out.println();
    }


    //20.1*************************************************************************************
    private static void _20_1() {
        //获取项目同文件夹下的文件方法：
        //File file = new File(类名.class.getResource("文件名.文件后缀").getPath());
        //脱离了恶心的直接拷贝路径法
        File file = new File(Exercise.class.getResource("words.txt").getPath());
        System.out.println("source file : ");
        String text = getWordsFromFile(file);
        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split(" ")));
        Collections.sort(words);
        System.out.println("Sort in natural order, capitalize first and then lowercase : ");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    private static String getWordsFromFile(File file) {
        String text = "";
        String temp = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((temp = br.readLine()) != null) {
                text += temp + " ";
            }
            System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }


    //test*************************************************************************************
    @Test
    public void test() {
        System.out.println(this.getClass().getResource("words.txt"));
        System.out.println(this.getClass().getPackage());
    }
}
