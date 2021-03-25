package training.expires.inputOutput;

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
