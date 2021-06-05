import edu.princeton.cs.algs4.StdIn;

import java.io.EOFException;

//reading input from main args error.
public class Permutation {
    public static void main(String[] args){
        //error here
        int k = Integer.parseInt(args[0]);
        //System.out.println(k);
        int n = 0;
        RandomizedQueue<String> Q = new RandomizedQueue<>();
        //and here
        boolean T =true;
        while(T){
            try {
                String x = StdIn.readString();
                Q.enqueue(x);
                n++;
            }
            catch(java.util.NoSuchElementException e){
                T = false;
            }
        }
        while(k!=0){
            if(k>n) k = n;
            System.out.println(Q.dequeue());
            k--;
        }
    }
}
