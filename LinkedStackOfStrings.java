public class LinkedStackOfStrings {
    private Node First = null;

    private class Node{
        String item;
        Node next;
    }

    public boolean isEmpty(){
        return First == null;
    }

    public void push(String item){
        Node oldFirst = First;
        First = new Node();
        First.item = item;
        First.next = oldFirst;
    }

    public String pop(){
        String item = First.item;
        First = First.next;
        return item;
    }
}
