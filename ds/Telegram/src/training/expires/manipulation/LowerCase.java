package training.expires.manipulation;

public class LowerCase implements IEncoder {

    // Lower case text
    @Override
    public String encode(String text) {
        String result;

        result = text.toLowerCase();

        return result;
    }
}
