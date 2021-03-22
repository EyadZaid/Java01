package training.expires;

public class MoveLeftOP implements IOpcodeExecutable{

    @Override
    public void execute(Memory memory) {
        memory.moveLeft();
    }
}
