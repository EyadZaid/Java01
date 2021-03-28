package training.expires.manipulation;

public class CaesarCipher implements IEncoder {
    private static final int UPPER = 'A';
    private static final int Lower = 'a';
    private static final int RANGE = 'Z' - 'A';
    private int shift;

    public CaesarCipher(int shift){
        this.shift = shift;
    }

    // Encrypts text - Caesar Cipher
    @Override
    public String encode(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch = (char) (((int) ch + shift - UPPER) % RANGE + UPPER);
            } else if(Character.isLowerCase(ch)) {
                ch = (char) (((int) ch + shift - Lower) % RANGE + Lower);
            }
            result.append(ch);
        }
        return result.toString();
    }
}
