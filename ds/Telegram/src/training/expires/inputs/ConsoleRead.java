package training.expires.inputs;

import java.util.Scanner;

public class ConsoleRead implements IInput{
    private String lineStr;
    private String prevLine;
    private Scanner scanner;

    public ConsoleRead(){
        lineStr = "";
        prevLine = "";
        scanner = new Scanner(System.in);
    }

    @Override
    public String readline() {
        prevLine = lineStr;
        lineStr = scanner.nextLine();
        return lineStr;
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
        scanner.close();
    }
}
