package blue.padge.chap01.exercise;

import blue.padge.chap01.Stack;
import edu.princeton.cs.algs4.StdOut;

public class exercise1_3_2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("it");
        stack.push("was");
        stack.push("-");
        stack.push("the");
        stack.push("best");
        stack.push("-");
        stack.push("of");
        stack.push("times");
        stack.push("-");
        stack.push("-");
        stack.push("-");
        stack.push("it");
        stack.push("was");
        stack.push("-");
        stack.push("the");
        stack.push("-");
        stack.push("-");

        while (!stack.isEmpty()) {
            StdOut.printf(stack.pop() + "\t");
        }

    }
}
