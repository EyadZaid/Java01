package training.expires;

public class IncrementOP implements IOpcodeExecutable {


    @Override
    public void execute(Memory memory) {
        memory.increment();
    }
}
