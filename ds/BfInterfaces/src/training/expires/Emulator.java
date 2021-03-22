package training.expires;

public class Emulator {
    private Memory memory;
    private Code code;
    private Display display;

    private IncrementOP incrementOP;
    private DecrementOP decrementOP;
    private MoveLeftOP moveLeftOP;
    private MoveRightOP moveRightOP;
    private StartLoopOP startLoopOP;
    private EndLoopOP endLoopOP;
    private PutValueOP putValueOP;
    private PutCharOP putCharOP;


    public Emulator(Display display){
        memory = new Memory();
        code = new Code();
        this.display = display;
        incrementOP = new IncrementOP();
        decrementOP = new DecrementOP();
        moveLeftOP = new MoveLeftOP();
        moveRightOP = new MoveRightOP();
        startLoopOP = new StartLoopOP(code);
        endLoopOP = new EndLoopOP(code);
        putCharOP = new PutCharOP(display);
        putValueOP = new PutValueOP(display);
    }

    public void load(char[] newCode){
        code = new Code(newCode);
    }

    public IOpcodeExecutable getOpcode(char ch){
        switch(ch){
            case '+':
                return incrementOP;

            case '-':
                return decrementOP;

            case '<':
                return moveLeftOP;

            case '>':
                return moveRightOP;

            case '.':
                return putValueOP;

            case '!':
                return putCharOP;

            case '[':
                return startLoopOP;

            case ']':
                return endLoopOP;

            default:
                assert false;
                return null;
        }
    }


    public void run() {
        while (!code.isOver()){
            char ch = code.getCurrentOpcode();
            IOpcodeExecutable opcode = getOpcode(ch);
            opcode.execute(memory);
        }
    }

    public void displayInput(){
        display.printInput(code.getItemsOfCode());
    }
}
