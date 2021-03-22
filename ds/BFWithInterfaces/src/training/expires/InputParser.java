package training.expires;

import java.util.Arrays;

public class InputParser {

    public char[] inputParsing(String source){
        /*
        char[] input = new char[source.length()];
        for (int i=0; i<source.length(); i++){
            input[i] = source.charAt(i);
        }
        return input;
         */

        assert source != null && source.length() > 0;
        char[] input = new char[source.length()];
        int indexInput = 0;

        for (int i=0; i<source.length(); i++){
            if (source.charAt(i) == Opcodes.INCREMENT.getOpcode() || source.charAt(i) == Opcodes.DECREMENT.getOpcode() ||
                    source.charAt(i) == Opcodes.MOVE_RIGHT.getOpcode() || source.charAt(i) == Opcodes.MOVE_LEFT.getOpcode() ||
                    source.charAt(i) == Opcodes.START_LOOP.getOpcode() || source.charAt(i) == Opcodes.END_LOOP.getOpcode() ||
                    source.charAt(i) == Opcodes.PRINT_CODE.getOpcode() || source.charAt(i) == Opcodes.PRINT_VALUE.getOpcode())

                input[indexInput++] = source.charAt(i);
        }
        input = Arrays.copyOfRange(input, 0, indexInput);
        return input;
    }
}
