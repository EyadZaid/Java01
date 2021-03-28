package training.expires.inputs;

import java.io.IOException;

public interface IInput {
    String readline();

    Boolean isEnd();

    void close();
}
