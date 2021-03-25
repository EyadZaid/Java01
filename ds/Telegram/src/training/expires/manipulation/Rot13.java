package training.expires.manipulation;

public class Rot13 implements IEncoder{

    @Override
    public String encode(String text) {
        String result="";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'm') {
                c += 13;
            }
            else if (c >= 'A' && c <= 'M') {
                c += 13;
            }
            else if (c >= 'n' && c <= 'z') {
                c -= 13;
            }
            else if (c >= 'N' && c <= 'Z') {
                c -= 13;
            }
            result += c;
        }

        return result;
    }
}
