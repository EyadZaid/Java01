package training.expires;

public class PutCharOP implements IOpcodeExecutable {
    public Display display;

    public PutCharOP(Display dis){
        display = dis;
    }

    @Override
    public void execute(Memory memory) {
        display.putChar(memory.getValue());
    }
}
