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
            switch (ch){

                case ('+'):
                    memory.increment();
                    break;

                case ('-'):
                    memory.decrement();
                    break;

                case ('>'):
                    memory.moveRight();
                    break;

                case ('<'):
                    memory.moveLeft();
                    break;

                case ('.'):
                    memory.printCode(ch);
                    break;

                case ('!'):
                    memory.printValue();
                    break;

                case ('['):
                    //-------------------------------
                    break;

                case (']'):
                    //------------------------------
                    break;

                default:
                    System.out.println("Exception");
            }
        }
    }
}
