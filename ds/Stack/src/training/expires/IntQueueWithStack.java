package training.expires;

public class IntQueueWithStack {
    private final static int CAPACITY = 32;
    private IntStack stack1;
    private IntStack stack2;

    public IntQueueWithStack(){
        this(CAPACITY);
    }

    public IntQueueWithStack(int size){
        if (size < 0){
            System.out.println("Exception: Size must be a positive number.");
            System.exit(1);
        }
        stack1 = new IntStack(size);
        stack2 = new IntStack(size);
    }

    public Boolean isEmpty() {
        return stack1.isEmpty();
    }

    public Boolean isFull() {
        return stack1.isFull();
    }

    public void enqueue(int n) {
        if (! isFull()) {
            stack1.push(n);
        }
        else {
            System.out.println("Exception: Queue is full.");
        }
    }

    public int dequeue() {
        if (isEmpty()){
            System.out.println("Exception: Queue is Empty.");
            return -999;
        }
        else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            int value = stack2.pop();

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return value;
        }
    }

    public int size() {
        return stack1.size();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Exception: Queue is Empty.");
            return -999;
        }
        else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            int value = stack2.peek();

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return value;
        }
    }

    @Override
    public String toString() {
        return "Queue{ " + stack1.toString() + "}";
    }
}
