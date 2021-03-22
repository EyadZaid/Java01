package training.expires;

public class StartLoopOP implements IOpcodeExecutable{
    private Code code;

    public StartLoopOP (Code c){
        code = c;
    }

    @Override
    public void execute(Memory memory) {
        memory.executeLoop(code);
    }
}
