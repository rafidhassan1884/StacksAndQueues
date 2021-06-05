
public class LinkedQueueOfStrings {
    private Node first,last;
    private class Node{
        String item;
        Node next;
    }

    public void enqueue(String item){
        Node oldLast = last;
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
    }

    public String dequeue(){
        Node oldFirst = first;
        first = first.next;
        if(isEmpty()) last = null;
        return oldFirst.item;
    }

    public boolean isEmpty(){
        return first == null;
    }
}
