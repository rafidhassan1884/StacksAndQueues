import java.util.Iterator;

public class GenericsLinkedStack <Item> implements Iterable<Item> {
    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    public void push(Item item) {
        Node OldFirst = first;
        first = new Node();
        first.item = item;
        first.next = OldFirst;
    }

    public Item pop() {
        Item out = first.item;
        first = first.next;
        return out;
    }

    public boolean isEmpty() {
        return first == null;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext(){ return current != null; }
        public void remove() { /*not supported*/}
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}