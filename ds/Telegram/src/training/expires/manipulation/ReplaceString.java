package training.expires.manipulation;

public class ReplaceString implements IReplaceString {

    // Replace string in the text
    public String replace(String text, String oldString, String newString) {
        String result;

        result = text.replace(oldString, newString);

        return result;
    }

}
