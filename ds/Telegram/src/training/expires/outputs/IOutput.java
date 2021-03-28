package training.expires.outputs;

import java.io.IOException;

public interface IOutput {
    void write(String line);

    void close();
}
