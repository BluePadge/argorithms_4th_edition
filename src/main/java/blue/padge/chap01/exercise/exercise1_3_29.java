package blue.padge.chap01.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 用环形链表实现 Queue 。环形链表也是一条链表,只是没有任何结点的链接为空,且只要链表非
 * 空则 last.next 的值为 first 。只能使用一个 Node 类型的实例变量( last )。
 */
public class exercise1_3_29 {

    public static void main(String[] args) {
        CircleQueue<String> circleQueue = new CircleQueue<>();
        circleQueue.enqueue("a");
        circleQueue.enqueue("b");
        circleQueue.enqueue("c");
        circleQueue.enqueue("d");
        circleQueue.enqueue("e");
        circleQueue.enqueue("f");
        circleQueue.enqueue("g");
        circleQueue.enqueue("h");
        while (!circleQueue.isEmpty()) {
            StdOut.println(circleQueue.dequeue());
        }
    }

    private static class CircleQueue<Item> {

        private Node<Item> last;
        private int N;

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void enqueue(Item item) {
            Node<Item> node = new Node<>();
            node.item = item;
//            node.next = null;
            if (isEmpty()) {
                last = node;
                last.next = last;
            } else {
                node.next = last.next;
                last.next = node;
                last = last.next;
            }
            N++;
        }

        public Item dequeue() {
            if (isEmpty()) {
                return null;
            }
            Item item = last.next.item;
            last.next = last.next.next;
            N--;
            return item;
        }
    }
}
