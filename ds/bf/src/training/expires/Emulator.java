package training.expires;

public class Emulator {
    private Memory memory;
    private Code code;
    private Display display;


    public Emulator(Display display){
        memory = new Memory();
        code = new Code();
        this.display = display;
    }

    public void load(char[] newCode){
        code = new Code(newCode);
    }

    public void run() {
        while (!code.isOver()){
            char ch = code.getCurrentOpcode();
            Opcodes opcode = code.getOpcode(ch);
            switch (opcode){

                case INCREMENT:
                    memory.increment();
                    break;

                case DECREMENT:
                    memory.decrement();
                    break;

                case MOVE_RIGHT:
                    memory.moveRight();
                    break;

                case MOVE_LEFT:
                    memory.moveLeft();
                    break;

                case PRINT_CODE:
                    memory.printCode();
                    break;

                case PRINT_VALUE:
                    memory.printValue();
                    break;

                case START_LOOP:
                    memory.executeLoop(code);
                    break;

                case END_LOOP:
                    memory.endLoop(code);
                    break;

                default:
                    System.out.println("Exception");
            }
        }
    }

    public void displayInput(){
        display.printInput(code.getItemsOfCode());
    }
}
