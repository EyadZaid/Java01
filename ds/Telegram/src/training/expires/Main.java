package training.expires;

import training.expires.manipulation.CaesarCipher;
import training.expires.manipulation.ReplaceString;
import training.expires.manipulation.XORCipher;

public class Main {

    public static void main(String[] args) {
        testTelegram();
    }

    public static void testTelegram(){
        InputConsole in = new InputConsole();
        String text = in.input();
        String result;

        System.out.println("Caesar Cipher:");
        CaesarCipher caesar = new CaesarCipher(5);
        result = caesar.encode(text);
        System.out.println(result);

        System.out.println("\nXOR Cipher:");
        XORCipher xor = new XORCipher('m');
        result = xor.encode(text);
        System.out.println(result);

        System.out.println("\nReplace String:");
        ReplaceString replace = new ReplaceString("cd", "#");
        result = replace.encode(text);
        System.out.println(result);



    }
}
