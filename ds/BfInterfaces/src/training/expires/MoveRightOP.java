package training.expires;

public class MoveRightOP implements IOpcodeExecutable{
    @Override
    public void execute(Memory memory) {
        memory.moveRight();
    }
}
