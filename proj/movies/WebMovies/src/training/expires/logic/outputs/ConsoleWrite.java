package training.expires.logic.outputs;

public class ConsoleWrite implements IOutput{
    @Override
    public void write(String str) {
        System.out.println(str);
    }

    @Override
    public void close() {
    }
}
