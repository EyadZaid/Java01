package training.expires;

public class Segment {
    private static final int CAPACITY = 8;
    private int[] data;
    private int currIndex;
    Segment next;

    public Segment() {
        data = new int[CAPACITY];
        currIndex = 0;
        next = null;
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
}
