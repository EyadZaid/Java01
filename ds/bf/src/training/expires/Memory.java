package training.expires;

public class Memory {
    private final static int CAPACITY = 16;
    private int[] data;
    private int currIndex;
    private IntStack stack;

    public Memory(){
        data = new int[CAPACITY];
        currIndex = data.length/2;
        stack = new IntStack(64);
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

    public void printCode(char c) {
        System.out.println(c);
    }

    public void executeLoop(Code code) {
        int index = code.getCurrentIndex();
        char opcode;

        if (stack.isEmpty() || stack.peek() != index) {
            stack.push(index);
        }

        if (data[currIndex] == 0) {
            opcode = code.getCurrentOpcodeByIndex(index);
            while (opcode != ']') {
                index++;
                if (index == code.getSize()) {
                    System.out.println("Exception");
                } else {
                    opcode = code.getCurrentOpcodeByIndex(index);
                }
            }
            stack.pop();
        }
    }


}
