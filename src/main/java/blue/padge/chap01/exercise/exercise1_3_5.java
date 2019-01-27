package blue.padge.chap01.exercise;

import blue.padge.chap01.Stack;
import edu.princeton.cs.algs4.StdOut;

public class exercise1_3_5 {
    private static void printBinValue(int value) {
        Stack<Integer> stack = new Stack<>();
        while (value > 0) {
            stack.push(value % 2);
            value /= 2;
        }
        while (!stack.isEmpty()) {
            StdOut.print(stack.pop());
        }
    }
    public static void main(String[] args) {
        printBinValue(50);
    }
}
