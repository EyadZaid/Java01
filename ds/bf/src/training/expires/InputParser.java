package training.expires;

public class InputParser {

    public char[] inputParsing(String source){
        char[] input = new char[source.length()];
        for (int i=0; i<source.length(); i++){
            input[i] = source.charAt(i);
        }
        return input;
    }
}
