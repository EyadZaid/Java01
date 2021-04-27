package training.expires.logic.outputs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite implements IOutput{
    private final BufferedWriter bufferedWriter;

    public FileWrite(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        bufferedWriter = new BufferedWriter(writer);
    }

    @Override
    public void write(String str) {
        try {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
