package training.expires;

import java.util.ArrayList;
import java.util.List;

public class SortedList<T> {
    private DoublyLinkedList<T> sortedList;
    private Comparator<T> comparator;

    public SortedList(Comparator<T> comparator){
        this.sortedList = new DoublyLinkedList<>();
        this.comparator = comparator;
    }

    public void add(T item){
        int index = whereToAdd(item);
        sortedList.insert(item, index);
    }

    private int whereToAdd(T item){
        int i;
        for (i=0; i<size(); i++){
            if (comparator.compare(item, get(i)) <= 0){
                return i;
            }
        }
        return i;
    }

    public int size(){
        return sortedList.size();
    }

    public int find(T item){
        return sortedList.find(item);
    }

    public T get(int index){
        return sortedList.get(index);
    }

    public void remove(int index){
        sortedList.remove(index);
    }

    @Override
    public String toString() {
        return sortedList.toString();
    }

    public void reverseRecur(){
        sortedList.setTail(sortedList.getHead());
        sortedList.setHead(reverseRecur(sortedList.getHead()));
    }

    public Node<T> reverseRecur(Node<T> current){
        if (current == null) {
            return current;
        }

        if (current.getNext() == null) {
            current.setPrev(null);
            return current;
        }

        Node<T> node = reverseRecur(current.getNext());
        current.getNext().setNext(current);
        current.setPrev(current.getNext());
        current.setNext(null);
        return node;
    }

    private List<T> linkedListToList(){
        List<T> list = new ArrayList<>();
        Node<T> node = sortedList.getHead();
        while (node != null) {
            list.add(node.getData());
            node = node.getNext();
        }
        return list;
    }

    public void printList(){
        List<T> list = linkedListToList();
        list.forEach(System.out::println);
        //list.stream().forEach(System.out::println);
    }
}
