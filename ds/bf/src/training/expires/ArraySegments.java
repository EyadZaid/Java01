package training.expires;

public class ArraySegments {
    private Segment head; //head

    public ArraySegments(){
        head = new Segment();
    }

    public void insertNumRightAndLeft(int num, boolean isRight){
        Segment currSegment = head;

        while (currSegment != null) {
            if (!currSegment.isFull()){
                currSegment.insert(num);
                return;
            }
            currSegment = currSegment.getNext();
        }

        Segment newSegment = new Segment();

        if(head != null){
            newSegment.insert(num);
            if (isRight){
                head.setNext(newSegment);
            }
            else {
                head.setPrev(newSegment);
                newSegment.setNext(head);
                head = newSegment;
            }
        }
        else {
            newSegment.insert(num);
            head = newSegment;
        }
    }


    public void printArraySegments(){
        Segment currSegment = head;

        while (currSegment != null) {
            currSegment.printSegment();
            //next segment
            currSegment = currSegment.getNext();
        }

    }

}
