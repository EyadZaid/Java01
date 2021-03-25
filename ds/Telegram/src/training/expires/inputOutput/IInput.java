package training.expires.inputOutput;

public interface IInput {
    String readline();

    Boolean isEnd();

    void close();
}
