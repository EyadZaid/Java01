package training.expires.inputs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead implements IInput{
    private String lineStr;
    private String prevLine;
    private FileReader reader;
    private BufferedReader bufferedReader;

    public FileRead(String fileName) throws FileNotFoundException {
        lineStr = "";
        prevLine = "";
        reader = new FileReader(fileName);
        bufferedReader = new BufferedReader(reader);
    }

    @Override
    public String readline() {
        prevLine = lineStr;
        try {
            if ((lineStr = bufferedReader.readLine()) != null) {
                return lineStr;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public Boolean isEnd() {
        if (prevLine.equals("") && lineStr.equals(".")){
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
