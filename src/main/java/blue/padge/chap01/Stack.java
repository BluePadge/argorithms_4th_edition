package blue.padge.chap01;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node cursor = first;

        @Override
        public boolean hasNext() {
            return cursor.next != null;
        }

        @Override
        public Item next() {
            Item item = cursor.item;
            cursor = cursor.next;
            return item;
        }

        @Override
        public void remove() {
            //leave empty
        }

    }

    private class Node{
        Item item;
        Node next;
    }

    private Node first;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        return first.item;
    }
}
