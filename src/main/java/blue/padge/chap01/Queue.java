package blue.padge.chap01;

public class Queue<Item> {
    private class Node{
        Item item;
        Node next;
    }

    private Node first, last;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }
}
