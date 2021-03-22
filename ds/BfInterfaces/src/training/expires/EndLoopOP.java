package training.expires;

public class EndLoopOP implements IOpcodeExecutable{
    private Code code;

    public EndLoopOP (Code c){
        code = c;
    }
    @Override
    public void execute(Memory memory) {
        memory.endLoop(code);
    }
}
