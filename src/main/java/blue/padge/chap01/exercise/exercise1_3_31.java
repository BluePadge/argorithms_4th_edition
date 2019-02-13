package blue.padge.chap01.exercise;

import blue.padge.chap01.DoubleNode;
import edu.princeton.cs.algs4.StdOut;

/**
 * 双向链表方法
 */
public class exercise1_3_31 {
    public static void main(String[] args) {
        DoubleNode<String> head = new DoubleNode<>();
        head.item = "0";
        printDoubleNode(head);
        append(head, "1");
        append(head, "2");
        append(head, "3");
        append(head, "4");
        append(head, "5");
        printDoubleNode(head);

        head = insertHead(head, "-1");
        printDoubleNode(head);

        head = deleteHead(head);
        printDoubleNode(head);

        deleteTail(head);
        printDoubleNode(head);

        insertPrevious(head, "3", "-3");
        printDoubleNode(head);
        insertPost(head, "3", "-4");
        printDoubleNode(head);

        deleteElement(head, "-3");
        printDoubleNode(head);
        deleteElement(head, "-4");
        printDoubleNode(head);
    }

    private static void deleteElement(DoubleNode<String> head, String target) {
        DoubleNode<String> cursor = head;
        DoubleNode<String> targetCursor = null;
        while (cursor != null) {
            if (target.equals(cursor.item)) {
                targetCursor = cursor;
                break;
            }
            cursor = cursor.next;
        }
        if (targetCursor == null) {
            return;
        }

        if (targetCursor.next == null) {
            targetCursor.previous.next = null;
            targetCursor.previous = null;
        } else {
            targetCursor.next.previous = targetCursor.previous;
            targetCursor.previous.next = targetCursor.next;
            targetCursor = null;
        }
    }

    private static void insertPost(DoubleNode<String> head, String target, String value) {
        DoubleNode<String> cursor = head;
        DoubleNode<String> targetCursor = null;
        while (cursor != null) {
            if (target.equals(cursor.item)) {
                targetCursor = cursor;
                break;
            }
            cursor = cursor.next;
        }
        if (targetCursor == null) {
            return;
        }

        DoubleNode<String> item = new DoubleNode<>();
        item.item = value;
        targetCursor.next.previous = item;
        item.next = targetCursor.next;
        item.previous = targetCursor;
        targetCursor.next = item;
    }

    private static void insertPrevious(DoubleNode<String> head, String target, String value) {
        DoubleNode<String> cursor = head;
        DoubleNode<String> targetCursor = null;
        while (cursor != null) {
            if (target.equals(cursor.item)) {
                targetCursor = cursor;
                break;
            }
            cursor = cursor.next;
        }
        if (targetCursor == null) {
            return;
        }

        DoubleNode<String> item = new DoubleNode<>();
        item.item = value;
        item.previous = targetCursor.previous;
        targetCursor.previous.next = item;
        item.next = targetCursor;
        targetCursor.previous = item;
    }

    static void deleteTail(DoubleNode<String> head) {
        DoubleNode<String> tailCursor = head;
        while (tailCursor.next != null) {
            tailCursor = tailCursor.next;
        }
        tailCursor.previous.next = null;
    }

    static DoubleNode<String> deleteHead(DoubleNode<String> head) {
        DoubleNode<String> newHead = head;
        head = head.next;
        head.previous = null;
        newHead = null;
        return head;
    }

    static DoubleNode<String> insertHead(DoubleNode<String> head, String value) {
        DoubleNode<String> item = new DoubleNode<>();
        item.item = value;
        if (head == null) {
            return item;
        }
        head.previous = item;
        item.next = head;
        return item;
    }

    static void append(DoubleNode<String> node, String value) {
        if (node == null) {
            return;
        }
        DoubleNode<String> cursor = node;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        DoubleNode<String> item = new DoubleNode<>();
        item.item = value;
        cursor.next = item;
        item.previous = cursor;
    }

    static void printDoubleNode(DoubleNode<String> doubleNode) {
        if (doubleNode == null) {
            StdOut.println("null");
            return;
        }
        DoubleNode<String> cursor = doubleNode;
        while (cursor != null) {
            StdOut.printf("%s\t", cursor.item);
            cursor = cursor.next;
        }
        StdOut.println();
    }
}
