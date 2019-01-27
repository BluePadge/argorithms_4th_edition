package blue.padge.chap01.exercise;

import blue.padge.chap01.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写一个过滤器InfixToPostfix，将算术表达式由中序表达式转为后序表达式
 * 编写一段程序EvaluatePostfix,计算一个后序表达式的值
 */
public class exercise1_3_11 {
    //    (3 + 4) × 5 - 6 -> "3 4 + 5 * 6 -";
    private static String[] infixToPostfix(String[] infixExp) {
        Map<String, Integer> valueMap = new HashMap<>();
        valueMap.put("(", 0);
        valueMap.put("+", 1);
        valueMap.put("-", 1);
        valueMap.put("*", 2);
        valueMap.put("/", 2);
        Stack<String> result = new Stack<>();
        Stack<String> opsStack = new Stack<>();
        for (int i = 0; i < infixExp.length; i++) {
            String value = infixExp[i];
            if ("(".equals(value)) {
                opsStack.push(value);
            } else if ("+".equals(value) || "-".equals(value)
                    || "*".equals(value) || "/".equals(value)) {
                if (opsStack.isEmpty()) {
                    opsStack.push(value);
                } else {
                    if (valueMap.get(value) > valueMap.get(opsStack.peek())) {
                        opsStack.push(value);
                    } else {
                        result.push(opsStack.pop());
                        opsStack.push(value);
                    }
                }
            } else if (")".equals(value)) {
                while (!"(".equals(opsStack.peek())) {
                    result.push(opsStack.pop());
                }
                opsStack.pop();
            } else {
                result.push(value);
            }
        }
        while (!opsStack.isEmpty()) {
            result.push(opsStack.pop());
        }
        String[] resultStrArray = new String[result.size()];
        for (int i = resultStrArray.length - 1; i >= 0; i--) {
            resultStrArray[i] = result.pop();
        }
        return resultStrArray;
    }

    private static double evaluatePostfix(String[] postExp) {
        Stack<Double> dataStack = new Stack<>();

        for (int i = 0; i < postExp.length; i++) {
            String value = postExp[i];
            if ("+".equals(value)) {
                double second = dataStack.pop();
                double first = dataStack.pop();
                dataStack.push(first + second);
            } else if ("-".equals(value)) {
                double second = dataStack.pop();
                double first = dataStack.pop();
                dataStack.push(first - second);
            } else if ("*".equals(value) || "x".equals(value)) {
                double second = dataStack.pop();
                double first = dataStack.pop();
                dataStack.push(first * second);
            } else if ("/".equals(value)) {
                double second = dataStack.pop();
                double first = dataStack.pop();
                dataStack.push(first / second);
            } else {
                dataStack.push(Double.parseDouble(value));
            }
        }
        return dataStack.pop();
    }

    public static void main(String[] args) {
        String postfixExp = "3 4 + 5 * 6 -";
        StdOut.println(evaluatePostfix(postfixExp.split(" ")));
        String infixExp = "( 3 + 4 ) * 5 - 6";
        infixToPostfix(infixExp.split(" "));
        StdOut.println(evaluatePostfix(infixToPostfix(infixExp.split(" "))));
        StdOut.println(evaluatePostfix(infixToPostfix("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )".split(" "))));
    }

}
