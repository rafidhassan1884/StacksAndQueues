import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item>{
    private Item[] s;
    private int N = 0;
    private int sz;
    public RandomizedQueue(){
        s =(Item[]) new Object[1]; //the Ugly Cast;
    }

    public void enqueue(Item item){
        if(item == null)
            throw new IllegalArgumentException("No argument");
        if(N == s.length) resize(2 * s.length);
        s[N++] = item;
        sz++;
    }

    private void resize(int len){
        Item[] copy =(Item[]) new Object[len];
        if(len>s.length){len = s.length;}
        for(int i=0;i<len;i++){copy[i] = s[i];}
        s = copy;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public Item dequeue(){
        if(isEmpty())
            throw new java.util.NoSuchElementException("empty queue");
        int pop = StdRandom.uniform(N);
        Item item = s[pop];
        s[pop] = s[--N];
        s[N] = null;
        sz--;
        if(N>0 && N==s.length/4){ resize(s.length/2);}
        return item;
    }

    public int size(){ return sz; }

    public Item sample(){
        if(isEmpty())
            throw new java.util.NoSuchElementException("empty queue");
        return s[StdRandom.uniform(N)];
    }

    public Iterator<Item> iterator(){ return new ReverseArrayIterator(); }

    private class ReverseArrayIterator implements Iterator<Item>{  //unclear about what implement does!! type-cast??
        private int i = N;

        public boolean hasNext(){ return i > 0;}
        public void remove() {
            throw new UnsupportedOperationException("Not Supported");
            /* not supported */
        }
        public Item next() {
            if(!hasNext())
                throw new java.util.NoSuchElementException("End of queue");
            int pop = StdRandom.uniform(i);
            Item item = s[pop];
            s[pop] = s[--i];
            return item;
        }
    }

    public static void main(String[] args){
        //unit testing
        RandomizedQueue<String> D = new RandomizedQueue<>();
        for(String x: args){
            D.enqueue(x);
        }
        Iterator<String> iterator = D.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
