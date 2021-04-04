package training.expires.inputs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead implements IInput{
    private String line;
    private FileReader reader;
    private BufferedReader bufferedReader;

    public FileRead(String fileName) throws FileNotFoundException {
        line = "";
        reader = new FileReader(fileName);
        bufferedReader = new BufferedReader(reader);
    }

    @Override
    public String readline() {
        try {
            if ((line = bufferedReader.readLine()) != null) {
                return line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public Boolean isEnd() {
        if (line == null || line.equals("")){
            return true;
        }
        return false;
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
