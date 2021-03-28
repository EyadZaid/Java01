package training.expires;

import training.expires.inputs.*;
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
        IEncoder encoder = new XORCipher('m');

        Telegram telegram = new Telegram(iInput, iOutput, encoder);
        telegram.encode();


        /*
        ConsoleRead consoleRead = new ConsoleRead();
        ReadText readText = new ReadText(consoleRead);
        List<String> text = readText.read();

        String result;

        System.out.println("Caesar Cipher:");
        CaesarCipher caesar = new CaesarCipher(5);
        result = caesar.encode(text.toString());
        System.out.println(result);

        System.out.println("\nXOR Cipher:");
        XORCipher xor = new XORCipher('m');
        result = xor.encode(text.toString());
        System.out.println(result);

        System.out.println("\nReplace String:");
        ReplaceString replace = new ReplaceString("cd", "#");
        result = replace.encode(text.toString());
        System.out.println(result);
*/


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

        IEncoder encoder = new XORCipher('m');

        Telegram telegram = new Telegram(iInput, iOutput, encoder);
        telegram.encode();
    }
}
