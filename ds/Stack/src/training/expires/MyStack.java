package training.expires;

public class MyStack {
    private int[] data;
    private int currIndex;

    public MyStack(){
        data = new int[8];
        currIndex = 0;
    }

    public MyStack(int size){
        if (size < 0){
            System.out.println("Exception: Size must be a positive number.");
            System.exit(0);
        }
        data = new int[size];
        currIndex = 0;
    }

    public boolean isEmpty() {
        return currIndex == 0;
    }

    public void push(int n){
        if (currIndex != data.length){
            data[currIndex] = n;
            ++currIndex;
        }
        else {
            System.out.println("Exception: The stack is full.");
        }
    }

    public int pop(){
        if (!isEmpty()){
            return data[--currIndex];
        }
        else {
            System.out.println("Exception: The stack is empty.");
            return -1;  // is not good
            //throw new RuntimeException("Exception: The stack is empty.");
        }
    }

    public int peek(){
        if (!isEmpty()){
            return data[currIndex-1];
        }
        else {
            System.out.println("Exception: The stack is empty.");
            return -1;  // is not good
            //throw new RuntimeException("Exception: The stack is empty.");
        }
    }

    public int size() {
        return currIndex;
    }

    public void clear(){
        while (!isEmpty()){
            pop();
        }
    }

    public void push(int... numbers){
        for (int i=0; i<numbers.length; i++){
            push(numbers[i]);
        }
    }
}
