package training.expires.manipulation;

public class ReplaceString implements IEncoder {
    private String oldString;
    private String newString;

    public ReplaceString(String oldString, String newString){
        this.oldString = oldString;
        this.newString = newString;
    }

    // Replace string in the text
    @Override
    public String encode(String text) {
        String result;

        result = text.replace(oldString, newString);

        return result;
    }
}
