
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>{
    private Node first, last;
    private int sz;
    private class Node{
        private Node next,pre;
        private Item item;
    }
    public Deque(){
        sz = 0;
        first = new Node();
        last = new Node();
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return sz;
    }

    public void addFirst(Item item){
        if(item == null)
            throw new IllegalArgumentException("No input detected");
        Node oldFirst = first;
        Node temp = new Node();
        temp.item = item;
        temp.next = oldFirst;
        temp.pre = null;
        if(isEmpty()) last = temp;
        first = temp;
        if(oldFirst!=null)
            oldFirst.pre = first;
        sz++;
    }

    public void addLast(Item item){
        if(item == null)
            throw new IllegalArgumentException("No input detected");
        Node oldLast = last;
        Node temp = new Node();
        temp.item = item;
        temp.next = null;
        temp.pre =oldLast;
        last = temp;
        if(isEmpty()) {
            first = last;
        }
        if(oldLast!=null) oldLast.next = last;
        sz++;
    }

    public Item removeFirst(){
        if(isEmpty())
            throw new java.util.NoSuchElementException("No Such Element");
        Item item = first.item;
        first = first.next;
        if(first != null)
            first.pre = null;
        sz--;
        return item;
    }

    public Item removeLast(){
        if(isEmpty())
            throw new java.util.NoSuchElementException("No Such Element");
        Item item = last.item;
        last = last.pre;
        last.next = null;
        sz--;
        //if(isEmpty()) last = null;
        return item;
        //last.next = null;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){ return current != null; }
        public void remove() {
            throw new UnsupportedOperationException("Not Supported");
            /* not supported */
        }
        public Item next() {
            if(!hasNext())
                throw new java.util.NoSuchElementException("End of deque");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args){
        Deque<String> D = new Deque<>();
        System.out.println(D.isEmpty());
        for(String x: args){
            D.addFirst(x);
        }
        System.out.println(D.removeLast());
        System.out.println(D.isEmpty());
        //while(!D.isEmpty()){
        //    System.out.println(D.removeLast());
        //}
        Iterator<String> iterator = D.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        /*while(!D.isEmpty()){
            System.out.println(D.removeFirst());
        }*/
    }
}