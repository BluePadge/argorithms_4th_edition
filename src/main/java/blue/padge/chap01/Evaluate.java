package blue.padge.chap01;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        String[] exp = new String[]{
                "(", "(", "1", "+", "sqrt", "(", "5.0", ")", ")", "/", "2.0", ")"
        };
        for (int i = 0; i < exp.length; i++) {
            String s = exp[i];
            switch (s) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    ops.push(s);
                    break;
                case ")":
                    String op = ops.pop();
                    double v = vals.pop();
                    if (op.equals("+")) {
                        v += vals.pop();
                    } else if (op.equals("-")) {
                        v = vals.pop() - v;
                    } else if (op.equals("*")) {
                        v *= vals.pop();
                    } else if (op.equals("/")) {
                        v = vals.pop() / v;
                    } else if (op.equals("sqrt")) {
                        v = Math.sqrt(v);
                    }
                    vals.push(v);
                    break;
                case " ":
                    break;
                default:
                    vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
