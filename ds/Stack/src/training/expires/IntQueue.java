package training.expires;

public class IntQueue {
    private final static int CAPACITY = 32;
    private int[] data;
    private int head;
    private int tail;
    private int currSize;

    public IntQueue(){
        this(CAPACITY);
    }

    public IntQueue(int size){
        if (size < 0){
            System.out.println("Exception: Size must be a positive number.");
            System.exit(1);
        }
        data = new int[size];
        head = 0;
        tail = -1;
        currSize =0;
    }

    public Boolean isEmpty() {
        return currSize == 0;
    }

    public Boolean isFull() {
        return currSize == data.length;
    }

    public void enqueue(int n) {
        if (! isFull()) {
            tail = (tail+1) % data.length;
            data[tail] = n;
            currSize++;
        }
        else {
            System.out.println("Exception: Queue is full.");
        }
    }

    public int dequeue() {
        /*
        assert !isEmpty();

        int value = data[head];
        head = (head+1) % data.length;
        currSize--;
        return value;
        */

        if (! isEmpty()){
            int value = data[head];
            head = (head+1) % data.length;
            currSize--;
           return value;
        }
        else {
            System.out.println("Exception: Queue is Empty.");
            return -1;
        }
    }

    public int size() {
        return currSize;
    }

    public int peek() {
        /*
        assert !isEmpty();
        return data[head];
        */

        if (! isEmpty()) {
            return data[head];
        }
        else {
            System.out.println("Exception: Queue is Empty.");
            return -1;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Queue{ data=[");
        int start, end;
        if (head < tail){
            start = head;
            end = tail;
        }
        else {
            start = tail;
            end = head;
        }
        if (currSize > 0){
            for (int i=start; i<=end; i++){
                if (i != end){
                    str.append(data[i] + ",");
                }
                else {
                    str.append(data[i]);
                }
            }
        }

        str.append("], head=" + head + ", tail=" + tail + ", currSize=" + currSize + '}');
        return str.toString();
    }
}
