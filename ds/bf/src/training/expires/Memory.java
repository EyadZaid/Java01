package training.expires;

public class Memory {
    private final static int CAPACITY = 16;
    private final static int INCREASE_DATA = 10;
    private int[] data;
    private int currIndex;
    private IntStack stack;

    public Memory(){
        data = new int[CAPACITY];
        currIndex = CAPACITY/2;
        stack = new IntStack(64);
    }

    public void increment() {
        data[currIndex]++;
    }

    public void decrement() {
        data[currIndex]--;
    }

    public void moveRight() {
        if (currIndex == getSizeData() -1){
            int[] newData = new int[getSizeData()+INCREASE_DATA];
            for (int i=0; i<data.length; i++){
                newData[i] = data[i];
            }
            data = newData;
        }
        currIndex++;
    }

    public void moveLeft() {
        if (currIndex == 0){
            int[] newData = new int[getSizeData()+INCREASE_DATA];
            for (int i=0; i<data.length; i++){
                newData[i+INCREASE_DATA] = data[i];
            }
            data = newData;
            currIndex = INCREASE_DATA;
        }
        currIndex--;
    }

    public void printValue() {
        System.out.print(data[currIndex]);
    }

    public void printCode() {
        System.out.print((char)data[currIndex]);
    }

    public void executeLoop(Code code) {
        int indexOfCode = code.getCurrentIndex();
        if (stack.isEmpty() || stack.peek() != indexOfCode) {
            stack.push(indexOfCode);
        }

        if (data[currIndex] <= 0) {
            char opcode = code.getCurrentOpcodeByIndex(indexOfCode);
            while (opcode != ']') {
                code.incCurrentIndex();
                indexOfCode = code.getCurrentIndex();
                if (indexOfCode == code.getSize()) {
                    System.out.println("Exception");
                    return;
                } else {
                    opcode = code.getCurrentOpcodeByIndex(indexOfCode);
                }
            }
            stack.pop();
            code.incCurrentIndex();
        }
    }

    public void endLoop(Code code) {
        if (stack.isEmpty()) {
            return;
        }

        code.setCurrIndex(stack.peek());
        code.dicCurrentIndex();
    }

    public int getSizeData(){
        return data.length;
    }


}
