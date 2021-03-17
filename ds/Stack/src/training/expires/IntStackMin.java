package training.expires;

public class IntStackMin {
    private int[] data;
    private MyStack minStack;
    private int dataIndex;

    public IntStackMin(){
        this(32);
    }

    public IntStackMin(int size){
        if (size < 0){
            System.out.println("Exception: Size must be a positive number.");
            System.exit(0);
        }
        data = new int[size];
        minStack = new MyStack(size);
        dataIndex = 0;
    }

    public boolean isEmpty() {
        return dataIndex == 0;
    }

    public void push(int n){
        if (dataIndex != data.length){
            insertMinNumToStack(n);
            data[dataIndex++] = n;
        }
        else {
            System.out.println("Exception: The stack is full.");
        }
    }


    private void insertMinNumToStack(int n){
        if (minStack.isEmpty()){
            minStack.push(n);
        }
        else if (minStack.peek() >= n) {
            minStack.push(n);
        }
    }

    public int pop(){
        if (!isEmpty()){
            if (minStack.peek() == data[dataIndex-1]){
                minStack.pop();
            }
            return data[--dataIndex];
        }
        else {
            System.out.println("Exception: The stack is empty.");
            return -1;  // is not good
        }
    }

    public int min(){
        if(!isEmpty()){
            return minStack.peek();
        }
        else {
            System.out.println("Exception: The stack is empty.");
            return -1;  // is not good
        }
    }

    public int peek(){
        if (!isEmpty()){
            return data[dataIndex -1];
        }
        else {
            System.out.println("Exception: The stack is empty.");
            return -1;  // is not good
        }
    }

    public int size() {
        return dataIndex;
    }

    public void clear(){
        dataIndex = 0;
    }

    public void push(int... numbers){
        int free = data.length - dataIndex;
        int minFree = Math.min(free, numbers.length);
        for (int i=0; i<minFree; i++){
            push(numbers[i]);
        }
    }
}
