//recheck things
//find bug

public class ResizingArrayQueueOfStrings {
    private String[] queue;
    private int head=0,tail=0;
    public ResizingArrayQueueOfStrings(){ queue = new String[1];}

    public void enqueue(String item){
        queue[tail++] = item;
        if(tail == queue.length){
            if(tail - head <= queue.length) resize(queue.length);
            else resize(2* queue.length);
        }
    }

    private void resize(int len){
        String[] copy = new String[len];
        for(int i=0; i<= tail - head; i++ )
            copy[i] = queue[head+i];
    }


    public String dequeue(){
        String item = queue[head];
        queue[head] = null;
        head++;
        return item;
    }

    public boolean isEmpty(){
        return head == tail;
    }
}
