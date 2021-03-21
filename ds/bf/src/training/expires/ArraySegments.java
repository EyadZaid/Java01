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
            currSegment = currSegment.next;
        }

        Segment newSegment = new Segment();

        if(head != null){
            newSegment.insert(num);
            if (isRight){
                head.next = newSegment;
            }
            else {
                head.prev = newSegment;
                newSegment.next = head;
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
            currSegment = currSegment.next;
        }

    }




}
