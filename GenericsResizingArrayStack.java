import java.util.Iterator;

public class GenericsResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] s;
    private int N = 0;
    public GenericsResizingArrayStack(){
        s =(Item[]) new Object[1]; //the Ugly Cast;
    }

    public void push(Item item){
        if(N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    private void resize(int len){
        Item[] copy =(Item[]) new Object[len];
        for(int i=0;i<s.length;i++){copy[i] = s[i];}
        s = copy;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public Item pop(){
        Item item = s[--N];
        s[N] = null;
        if(N>0 && N==s.length/4){ resize(s.length/2);}
        return item;
    }

    public Iterator<Item> iterator(){ return new ReverseArrayIterator(); }

    private class ReverseArrayIterator implements Iterator<Item>{  //unclear about what implement does!! type-cast??
        private int i = N;

        public boolean hasNext(){ return i > 0;}
        public void remove() { /* not supported */}
        public Item next() { return s[--i];}
    }
}
