public class ResizingArrayStackOfStrings {
    private String[] s;
    private int N = 0;
    public ResizingArrayStackOfStrings(){
        s = new String[1];
    }

    public void push(String item){
        if(N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    private void resize(int len){
        String[] copy = new String[len];
        for(int i=0;i<s.length;i++){copy[i] = s[i];}
        s = copy;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public String pop(){
        String item = s[--N];
        s[N] = null;
        if(N>0 && N==s.length/4){ resize(s.length/2);}
        return item;
    }
}
