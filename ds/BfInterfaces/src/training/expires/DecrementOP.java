package training.expires;

public class DecrementOP implements IOpcodeExecutable{

    @Override
    public void execute(Memory memory) {
        memory.decrement();
    }
}
