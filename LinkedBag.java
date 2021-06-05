import java.util.Iterator;

public class LinkedBag<Item> implements Iterable<Item>{
    private Node first = null;
    private int sz = 0;

    private class Node{
        Item item;
        Node next;
    }

    public void add(Item item){
        //using Stack;
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        sz++;
    }

    public int size() {return sz;}

    public Iterator<Item> iterator(){
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext() { return current != null;}
        public void remove() { /* not supported */}
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
