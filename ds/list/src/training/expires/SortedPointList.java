package training.expires;

public class SortedPointList {
    private DoublyLinkedList<Point> list;
    private PointComparator comparator;

    public SortedPointList(PointComparator comparator){
        this.list = new DoublyLinkedList<>();
        this.comparator = comparator;
    }

    public int size(){
        return list.size();
    }


    public void addPoint(Point p){
        if (size() == 0){
            list.addAtHead(p);
        }
        else {
            if (comparator.compare(list.getHead().getData(), p) >= 0) {
                list.addAtHead(p);
            }
            else {
                if (comparator.compare(list.get(size()-1), p) <= 0) {
                    list.addAtTail(p);
                }
                else {
                    for (int i=0; i<size(); i++){
                        if (comparator.compare(list.get(i), p) >= 0){
                            list.insert(p, i);
                        }
                    }
                }
            }
        }
    }


    @Override
    public String toString() {
        return list.toString();
    }

    public void reverseRecur(){
        list.setHead(reverseRecur(list.getHead()));
    }


    public Node<Point> reverseRecur(Node<Point> current){
        if (current == null) {
            return current;
        }

        if (current.getNext() == null) {
            current.setPrev(null);
            return current;
        }

        Node<Point> node = reverseRecur(current.getNext());
        current.getNext().setNext(current);
        current.setPrev(current.getNext());
        current.setNext(null);
        return node;
    }


    public void reverseList(){
        Node<Point> previous = null;
        list.setTail(list.getHead());
        Node<Point> current = list.getHead();
        while(current != null){
            previous = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(previous);
            current = current.getPrev();
        }
        if(previous != null){
            list.setHead(previous.getPrev());
        }
    }



    /*
    public void addPoint(Point p){
        if (size() == 0){
           list.addAtHead(p);
           return;
        }

        if (size() == 1){
            if ( comparator.compare(list.getHead().getData(), p) >= 0){
                list.addAtHead(p);
            }
            else {
                list.addAtTail(p);
            }
        }
        else {
            if (comparator.compare(list.getHead().getData(), p) >= 0){
                list.addAtHead(p);
            }
            else {
                if (comparator.compare(list.get(size()-1), p) <= 0) {
                    list.addAtTail(p);
                }
                else {

                    for (int i=0; i<size(); i++){
                        if (comparator.compare(list.get(i), p) >= 0){
                            list.insert(p, i);
                        }
                    }
                }
            }
        }
    }
     */

}
