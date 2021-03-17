package training.expires;

import java.util.Arrays;

public class IntStack {
    private int[] data;
    private int currIndex;

    public IntStack(){
        this(32);
    }

    public IntStack(int size){
        if (size < 0){
            System.out.println("Exception: Size must be a positive number.");
            System.exit(1);
        }
        data = new int[size];
        currIndex = 0;
    }

    public boolean isEmpty() {
        return currIndex == 0;
    }

    public Boolean isFull() {
        return currIndex == data.length;
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
        int free = data.length - currIndex;
        int minFree = Math.min(free, numbers.length);
        for (int i=0; i<minFree; i++){
            push(numbers[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Stack{ data=[");
        if (currIndex > 0){
            for (int i=0; i<currIndex; i++){
                if (i != currIndex-1){
                    str.append(data[i] + ",");
                }
                else {
                    str.append(data[i]);
                }
            }
        }
        str.append("], currIndex=" + currIndex + '}');

        return str.toString();
    }
}
