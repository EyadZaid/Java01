package training.expires;

import training.expires.inputOutput.*;
import training.expires.manipulation.CaesarCipher;
import training.expires.manipulation.IEncoder;

public class Main {

    public static void main(String[] args) {
        testTelegram();
    }

    public static void testTelegram(){
        IInput iInput = new ConsoleRead();
        IOutput iOutput = new ConsoleWrite();
        IEncoder iEncoder = new CaesarCipher(5);

        Telegram telegram = new Telegram(iInput, iOutput, iEncoder);
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
}
