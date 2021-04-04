package training.expires.inputs;

public interface IInput {
    String readline();

    Boolean isEnd();

    void close();
}
