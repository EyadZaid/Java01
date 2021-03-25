package training.expires.inputOutput;

public interface IInput {
    String line();

    Boolean isEnd();

    void close();
}
