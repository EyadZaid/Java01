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
        char opcode;

        if (stack.isEmpty() || stack.peek() != code.getCurrentIndex()) {
            stack.push(code.getCurrentIndex());
        }

        if (data[currIndex] == 0) {
            opcode = code.getCurrentOpcodeByIndex(code.getCurrentIndex());
            while (opcode != ']') {
                code.incCurrentIndex();
                if (code.getCurrentIndex() == code.getSize()) {
                    System.out.println("Exception");
                    return;
                } else {
                    opcode = code.getCurrentOpcodeByIndex(code.getCurrentIndex());
                }
            }
            stack.pop();
            code.incCurrentIndex();
        }
    }

    public void endLoop(Code code) {
        if (stack.isEmpty()) {
            System.out.println("Exception");
            return;
        }

        code.setCurrIndex(stack.peek());
        code.dicCurrentIndex();
    }


}
