package training.expires;

public class ArraySegments {
    private Segment head; //head

    public ArraySegments(){
        head = new Segment();
    }

    //Right insert --------------------
    public void insertNum(int num){

        if(head != null && !head.isFull()){
            head.insert(num);
            return;
        }

        Segment newSegment = new Segment();

        if(head != null){
            newSegment.insert(num);
            head.next = newSegment;
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
