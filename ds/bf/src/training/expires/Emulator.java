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
            switch (code.GetCurrentOpcode()){

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
                    memory.printValue();
                    break;

                default:
                    System.out.println("Exception");
            }
        }
    }
}
