package training.expires.inputs;

public interface IInputData {
    String readline();

    Boolean isEnd();

    void close();
}
