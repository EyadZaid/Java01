package training.expires;

public class PutValueOP implements IOpcodeExecutable{
    public Display display;

    public PutValueOP(Display dis){
        display = dis;
    }

    @Override
    public void execute(Memory memory) {
        display.putValue(memory.getValue());
    }
}
