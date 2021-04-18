package training.expires;

public class ThreadSafeQueue<T> {
    private T[] data;
    private int capacity;
    private int size;
    private int front;
    private int rear;

    public ThreadSafeQueue(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = capacity - 1;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public void enqueue(T item){
        if (isFull()){
            return;
        }

        rear = (rear + 1)  % capacity;
        data[rear] = item;
        size++;
    }

    public T dequeue(){
        if (isEmpty()){
            return null;
        }

        T item = data[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }




}
