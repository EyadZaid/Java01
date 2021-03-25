package training.expires.manipulation;

public class XORCipher implements IEncoder{
    private int key;

    public XORCipher(int key){
        this.key = key;
    }

    // Encrypts text - XOR Cipher
    @Override
    public String encode(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            result += Character.toString((char) (text.charAt(i) ^ key));
        }

        return result;
    }
}
