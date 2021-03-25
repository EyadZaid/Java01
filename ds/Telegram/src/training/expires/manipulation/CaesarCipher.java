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
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) + shift - UPPER) % RANGE + UPPER);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) + shift - Lower) % RANGE + Lower);
                result.append(ch);
            }
        }
        return result.toString();
    }
}
