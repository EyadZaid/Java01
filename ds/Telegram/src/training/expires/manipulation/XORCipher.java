package training.expires.manipulation;

public class XORCipher implements IXORCipher{

    // Encrypts text - XOR Cipher
    public String encrypt(String text, char key) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            result += Character.toString((char) (text.charAt(i) ^ key));
        }

        return result;
    }
}
