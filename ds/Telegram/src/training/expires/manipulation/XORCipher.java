package training.expires.manipulation;

public class XORCipher implements IEncoder{
    private String key;

    public XORCipher(String key){
        this.key = key;
    }

    // Encrypts text - XOR Cipher
    @Override
    public String encode(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int res = (key.charAt(i%key.length())) ^ ch;

            result += (char) res;
        }
        return result;
    }
}
