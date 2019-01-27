package blue.padge.chap01.exercise;

import blue.padge.chap01.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一段程序,从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式
 */
public class exercise1_3_9 {
    private static void completeExp(String[] exp) {
        Stack<String> dataStack = new Stack<>();
        Stack<String> opsStack = new Stack<>();
        for (int i = 0; i < exp.length; i++) {
            String current = exp[i];
            if (current.equals(")")) {
                String second = dataStack.pop();
                String first = dataStack.pop();
                String ops = opsStack.pop();
                dataStack.push("(" + first + ops + second + ")");
            } else if (current.equals("+")
                    || current.equals("-")
                    || current.equals("*")
                    || current.equals("/")) {
                opsStack.push(current);
            } else {
                dataStack.push(current);
            }
        }
//        for (String item : dataStack) {
//            StdOut.printf(item);
//        }
        while (!dataStack.isEmpty()) {
            StdOut.printf(dataStack.pop());
        }
    }

    public static void main(String[] args) {
        String[] exp = new String[]{
                "1", "+", "2", ")", "*", "3", "-", "4", ")"
                , "*", "5", "-", "6", ")", ")", ")"
        };
        completeExp(exp);
    }

}
