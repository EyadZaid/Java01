package training.expires.manipulation;

public class UpperCase implements IEncoder {

    // Upper case text
    @Override
    public String encode(String text) {
        String result;

        result = text.toLowerCase();

        return result;
    }
}
