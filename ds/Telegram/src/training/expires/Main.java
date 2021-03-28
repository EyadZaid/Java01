package training.expires;

import training.expires.inputs.*;
import training.expires.manipulation.CaesarCipher;
import training.expires.manipulation.IEncoder;
import training.expires.manipulation.XORCipher;
import training.expires.outputs.ConsoleWrite;
import training.expires.outputs.FileWrite;
import training.expires.outputs.IOutput;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //testConsoleTelegram();
        testFileTelegram();
    }

    public static void testConsoleTelegram(){
        IInput iInput = new ConsoleRead();
        IOutput iOutput = new ConsoleWrite();
        IEncoder[] encoders = new IEncoder[2];
        encoders[0] = new CaesarCipher(5);
        encoders[1] = new XORCipher("abc");

        Telegram telegram = new Telegram(iInput, iOutput, encoders);
        telegram.encode();
    }

    public static void testFileTelegram(){

        IInput iInput = null;
        try {
            iInput = new FileRead("input.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        IOutput iOutput = null;
        try {
            iOutput = new FileWrite("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        IEncoder[] encoders = new IEncoder[2];
        encoders[0] = new CaesarCipher(3);
        encoders[1] = new XORCipher("you");

        Telegram telegram = new Telegram(iInput, iOutput, encoders);
        telegram.encode();
    }
}
