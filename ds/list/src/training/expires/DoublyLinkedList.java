package training.expires;

import java.util.Objects;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    //Find item in the list
    public int find(T item){
        int index = 0;
        Node<T> currNode = head;
        while (currNode != null) {
            if (currNode.getData() == item){
                return index;
            }
            index++;
            currNode = currNode.getNext();
        }
        return -1;
    }

    //Length of the list
    public int size(){
        int size = 0;
        Node<T> currNode = head;
        while (currNode != null) {
            size++;
            currNode = currNode.getNext();
        }
        return size;
    }

    //Get item by index
    public T get(int index){
        T item = null;
        if (head == null)
            return null;

        Node<T> currNode = head;
        if (index == 0) {
            return head.getData();
        }

        for (int i=0; currNode!=null && i<index-1; i++)
            currNode = currNode.getNext();

        if (currNode == null || currNode.getNext() == null)
            return null;

        return currNode.getData();
    }

    // Adding node at the head
    public void addAtHead(T item){
        Node<T> node = new Node<>(item);
        node.setNext(head);
        node.setPrev(null);

        if (head != null) {
            head.setPrev(node);
        }
        else {
            tail = node;
        }
        head = node;
    }

    // Adding node at the tail
    public void addAtTail(T item){
        Node<T> node = new Node<>(item);
        node.setNext(null);
        node.setPrev(tail);

        if (tail != null) {
            tail.setNext(node);
        }
        else{
            head = node;
        }
        tail = node;
    }

    //Insert at given index
    public void insert(T item, int at){
        Node<T> currNode, prevNode;
        currNode = head;
        for (int i=0; i<at; i++){
            if (currNode != null){
                currNode = currNode.getNext();
            }
            else {
                System.out.println("Exception: Given node cannot be NULL");
                return;
            }
        }
        prevNode = currNode.getPrev();
        insertAfter(item, prevNode);
    }


    //Insert after given node
    public void insertAfter(T item, Node<T> where){
        if (where == null){
            System.out.println("Exception: Given node cannot be NULL");
            return;
        }

        Node<T> node = new Node<>(item);
        node.setNext(where.getNext());
        where.setNext(node);
        node.setPrev(where);

        if (node.getNext() != null){
            node.getNext().setPrev(node);
        }
        else {
            tail = node;
        }
    }

    public Node<T> not(Node<T> other){
        DoublyLinkedList<T> result = null;
        Node<T> currNode;
        currNode = other;
        while (currNode != null){
            if (find(currNode.getData()) == -1){
                addAtTail(result, currNode.getData());
            }
            currNode = currNode.getNext();
        }
        return result.head;
    }

    //Remove node at index
    public void remove(int index){
        if (head == null)
            return;

        Node<T> temp = head;
        if (index == 0) {
            head = temp.getNext();
            return;
        }

        for (int i=0; temp!=null && i<index-1; i++)
            temp = temp.getNext();

        if (temp == null || temp.getNext() == null)
            return;

        Node<T> next = temp.getNext().getNext();
        if (next == null){
            tail = temp;
        }
        temp.setNext(next);
    }

    public void addAtTail(DoublyLinkedList<T> list, T item){
        list.addAtTail(item);
    }

    public void addAtHead(DoublyLinkedList<T> list, T item){
        list.addAtHead(item);
    }

    public Node<T> getHead() {
        return head;
    }

    //Intersection
    public Node<T> intersection(Node<T> other){
        DoublyLinkedList<T> result = null;
        Node<T> currNode;
        currNode = other;
        while (currNode != null){
            if (find(currNode.getData()) != -1){
                addAtTail(result, currNode.getData());
            }
            currNode = currNode.getNext();
        }
        return result.head;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> node = head;
        while (node != null) {
            str.append(node.getData() + " ");
            node = node.getNext();
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        DoublyLinkedList<?> list = (DoublyLinkedList<?>) o;
        return Objects.equals(head, list.head) && Objects.equals(tail, list.tail);
    }

}
