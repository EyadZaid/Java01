package training.expires.outputs;

public class ConsoleWrite implements IOutput{
    @Override
    public void write(String line) {
        System.out.println(line);
    }

    @Override
    public void close() {
        System.out.println("Closed");
    }
}
