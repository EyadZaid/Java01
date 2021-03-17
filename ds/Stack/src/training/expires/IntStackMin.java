package training.expires;

public class IntStackMin {
    private int[] data;
    private int[] minArr;
    private int dataIndex;
    private int minArrIndex;

    public IntStackMin(){
        this(32);
    }

    public IntStackMin(int size){
        if (size < 0){
            System.out.println("Exception: Size must be a positive number.");
            System.exit(0);
        }
        data = new int[size];
        minArr = new int[size];
        dataIndex = 0;
        minArrIndex = 0;
    }

    public boolean isEmpty() {
        return dataIndex == 0;
    }

    public void push(int n){
        if (dataIndex != data.length){
            insertMinNumToArray(n);
            data[dataIndex++] = n;
        }
        else {
            System.out.println("Exception: The stack is full.");
        }
    }

    private void insertMinNumToArray(int n){
        if (minArrIndex == 0){
            minArr[minArrIndex++] = n;
        }
        else if (n <= minArr[minArrIndex-1]){
            minArr[minArrIndex++] = n;
        }
    }

    public int pop(){
        if (!isEmpty()){
            if (minArr[minArrIndex-1] == data[dataIndex-1]){
                minArrIndex--;
            }
            return data[--dataIndex];
        }
        else {
            System.out.println("Exception: The stack is empty.");
            return -1;  // is not good
            //throw new RuntimeException("Exception: The stack is empty.");
        }
    }

    public int min(){
        if(!isEmpty()){
            return minArr[minArrIndex-1];
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
            //throw new RuntimeException("Exception: The stack is empty.");
        }
    }

    public int size() {
        return dataIndex;
    }

    public void clear(){
        dataIndex = 0;
        minArrIndex = 0;
    }

    public void push(int... numbers){
        int free = data.length - dataIndex;
        int minFree = Math.min(free, numbers.length);
        for (int i=0; i<minFree; i++){
            push(numbers[i]);
        }
    }
}
