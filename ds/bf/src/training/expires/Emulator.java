package training.expires;

public class Emulator {
    private Memory memory;
    private Code code;


    public Emulator(char[] newCode){
        memory = new Memory();
        code = new Code(newCode);
    }

    public void runCurrentOpcode() {
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
                    memory.printCode(ch);
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
}
