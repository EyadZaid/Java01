package training.expires;

public class Emulator {
    private Memory memory;
    private Code code;

    public Emulator(char[] newCode){
        memory = new Memory();
        code = new Code(newCode);
    }

    
}
