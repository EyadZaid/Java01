package training.expires;

public class Memory {
    private final static int CAPACITY = 16;
    private int[] data;
    private int currIndex;

    public Memory(){
        data = new int[CAPACITY];
        currIndex = data.length/2;
    }

    public void increment() {
        data[currIndex]++;
    }

    public void decrement() {
        data[currIndex]--;
    }

    public void moveRight() {
        currIndex = (currIndex + 1) % data.length;
    }

    public void moveLeft() {
        currIndex = (currIndex - 1) % data.length;
    }

    public void printValue() {
        System.out.println(data[currIndex]);
    }




}
