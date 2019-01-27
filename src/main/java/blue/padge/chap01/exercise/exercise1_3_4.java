package blue.padge.chap01.exercise;

import blue.padge.chap01.Stack;
import edu.princeton.cs.algs4.StdOut;

public class exercise1_3_4 {
    private static boolean isParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char charItem = str.charAt(i);
            if (charItem == ')') {
                if (stack.pop() != '(') {
                    return false;
                }
            } else if (charItem == ']') {
                if (stack.pop() != '[') {
                    return false;
                }
            } else if (charItem == '}') {
                if (stack.pop() != '{') {
                    return false;
                }
            } else {
                stack.push(charItem);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        StdOut.println(isParentheses("[(])"));
        StdOut.println(isParentheses("[()]{}{[()()]()}"));
    }
}
