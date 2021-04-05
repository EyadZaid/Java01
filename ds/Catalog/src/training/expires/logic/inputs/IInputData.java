package training.expires.logic.inputs;

public interface IInputData {
    String readline();

    Boolean isEnd();

    void close();
}
