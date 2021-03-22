package training.expires;

public class Node<T> {
    private T data;
    private Node next;
    private Node prev;

    public Node(T d){
        data = d;
        next = null;
        prev =null;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public T getData() {
        return data;
    }
}
