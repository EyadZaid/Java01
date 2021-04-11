package training.expires;

public class Node<T> {
    private final T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T d){
        data = d;
        next = null;
        prev =null;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public T getData() {
        return data;
    }
}
