package training.expires.manipulation;

public class CaesarCipher implements ICaesarCipher {

    // Encrypts text - Caesar Cipher
    public String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) + shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) + shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }
}
