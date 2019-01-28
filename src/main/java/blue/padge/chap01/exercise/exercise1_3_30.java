package blue.padge.chap01.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个函数,接受一条链表的首结点作为参数,(破坏性地)将链表反转并返回结果链表的
 * 首结点。
 */
public class exercise1_3_30 {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>();
        head.item = 0;
        Node<Integer> cursor = head;
        for (int i = 1; i < 21; i++) {
            Node<Integer> node = new Node<>();
            node.item = i;
            cursor.next = node;
            cursor = cursor.next;
        }

        printNode(head);
        StdOut.println();
        StdOut.println("-------------------");
        printNode(reverseInterator(head));
        StdOut.println();
        StdOut.println("-------------------");
        printNode(reverseRecursion(head));
    }

    private static void printNode(Node<Integer> node) {
        while (node != null) {
            StdOut.printf("" + node.item + "\t");
            node = node.next;
        }
    }

    private static Node<Integer> reverseInterator(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node first = head;

        Node result = null;

        while (first != null) {
            Node second = first.next;
            first.next = result;
            result = first;
            first = second;
        }


        return result;
    }

    private static Node reverseRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node second = head.next;
        Node rest = reverseRecursion(second);
        second.next = head;
        head.next = null;
        return rest;
    }
}
