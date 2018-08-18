package basic.Collection;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ProjectName: JavaCode
 * @Package: basic.Collection
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/15 17:06
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/15 17:06
 */
public class exercise_evaluate {
    /**
     * 用户输入一串字符串，这串字符串是一个表达式
     * 接收这个字符串，分割整个字符串为数字、符号、四则运算符、括号四个部分
     * 当：
     * 1.读取到数字：
     * 检查负号布尔，为真则取反再入栈，为假直接入栈
     * 2.读取到符号：
     * 2.1.读取到 + - 号：
     * 如果读取到 + 号，入栈
     * 如果读取到 - 号，要判断它是“减号”还是“负号”。若为后者，不入栈，并标记布尔为假
     * 若为前者，则遍历操作数栈与运算符栈进行四则运算
     * 2.2.读取到 * / 号：
     * 遍历操作数栈与运算符栈进行乘除运算
     * 2.3.读取到 ( 号：
     * 入栈
     * 2.4.读取到 ) 号：
     * 在遍历到 ( 号之前，遍历操作数栈与运算符栈进行四则运算
     */

    private static Stack<Integer> numsStack = new Stack<>();//操作数栈
    private static Stack<String> operatorStack = new Stack<String>();//运算符栈

    public static void main(String[] args) {
        while (true) {
            System.out.println("enter a expression:");
            String expression = new Scanner(System.in).nextLine();
            if (expression.equalsIgnoreCase("exit")) {
                break;
            }
            if (expression.length() == 0) {
                System.out.println("Wrong input.");
            } else {
                evaluateExpression(expression.replaceAll(" ", ""));
            }
        }
    }

    private static void evaluateExpression(String expression) {

//        解析表达式
        expression = analysisExpression(expression);
//        计算表达式
        operateExpression(expression);
    }

    private static String analysisExpression(String expression) {
        String result = new String();
        for (char ch : expression.toCharArray()) {
            if ("+-*/()".contains(String.valueOf(ch))) {
                result += " " + ch + " ";
            } else result += ch;
        }
        return result;
    }


    private static void operateExpression(String expression) {
        String[] tokens = expression.split(" ");
        boolean nag = false;
        for (int i = 0; i < tokens.length; i++) {
            //如果是空字符串
            if (tokens[i].equals("")) continue;
            //如果是加减
            if ("+-".contains(tokens[i])) {
                if (tokens[i].equals("-") && (operatorStack.empty() || operatorStack.peek().equals("("))) {
                    nag = true;
                }
                while (!operatorStack.empty() && "*/+-".contains(operatorStack.peek())) {
                    calculate(numsStack, operatorStack);
                }
                if (!nag) {
                    operatorStack.push(tokens[i]);
                }
            }
            //如果是乘除
            else if ("*/".contains(tokens[i])) {
                while (!operatorStack.empty() && "*/".contains(operatorStack.peek())) {
                    calculate(numsStack, operatorStack);
                }
                operatorStack.push(tokens[i]);
            }
            //如果是左括号
            else if (tokens[i].equals("(")) {
                operatorStack.push(tokens[i]);
            }
            //如果是右括号
            else if (tokens[i].equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    calculate(numsStack, operatorStack);
                }
                operatorStack.pop();
            }
            //如果是数字
            else if (Integer.valueOf(tokens[i]) instanceof Number) {
                numsStack.push(nag ? -Integer.valueOf(tokens[i]) : Integer.valueOf(tokens[i]));
                nag = false;
            }
        }
        while (!operatorStack.empty()) {
            calculate(numsStack, operatorStack);
        }
//        calculate(numsStack, operatorStack);
        System.out.println("= " + numsStack.pop());
    }

    private static void calculate(Stack<Integer> numsStack, Stack<String> operatorStack) {
        String op = operatorStack.pop();
        int num1 = numsStack.pop();
        int num2 = numsStack.pop();
        switch (op) {
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

    @Test
    public void test() {
        char a = "a".charAt(0);
        System.out.println(Integer.valueOf(a));
    }
}