package blue.padge.chap01.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个方法 max() ,接受一条链表的首结点作为参数,返回链表中键最大的节点的值。假设所
 * 有键均为正整数,如果链表为空则返回 0。
 * 采用递归实现
 */
public class exercise1_3_27 {
    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }

    static int max(Node<Integer> head) {
//        return max(head, 0);
        int temp = 0;
        if (head == null) {
            return temp;
        }
        temp = max(head.next);
        return temp;
    }

    static int max(Node<Integer> head, int value) {
        if (head == null) {
            return value;
        }
        return max(head.next, head.item > value ? head.item : value);
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>();
        head.item = 10;
        Node<Integer> cursor = head;
        for (int i = 0; i < 12; i++) {
            Node<Integer> valueNode = new Node<>();
            valueNode.item = i;
            cursor.next = valueNode;
            cursor = cursor.next;
        }
        StdOut.println(max(head));
    }
}
