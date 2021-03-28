package training.expires.inputs;

import java.io.IOException;

public interface IInput {
    String readline() throws IOException;

    Boolean isEnd();

    void close() throws IOException;
}
