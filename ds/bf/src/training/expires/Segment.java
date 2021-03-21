package training.expires;

public class Segment {
    private static final int CAPACITY = 8;
    private int[] data;
    private int currIndex;
    private Segment next;
    private Segment prev;

    public Segment() {
        data = new int[CAPACITY];
        currIndex = 0;
        next = null;
        prev = null;
    }

    public void insert(int num){
        data[currIndex++] = num;
    }

    public int getCurrIndex(){
        return currIndex;
    }

    public int getCurrValue(){
        return data[currIndex];
    }

    public int getCurrValueByIndex(int index){
        return data[index];
    }

    public boolean isFull(){
        return currIndex == data.length;
    }

    public void printSegment(){
        for (int i=0; i<currIndex; i++){
            System.out.print(getCurrValueByIndex(i) + " ");
        }
    }

    public Segment getNext() {
        return next;
    }

    public Segment getPrev() {
        return prev;
    }

    public void setNext(Segment next){
        this.next = next;
    }

    public void setPrev(Segment prev){
        this.prev = prev;
    }
}
