package training.expires;

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
}
