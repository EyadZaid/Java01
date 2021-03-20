package training.expires;

public class Main {

    public static void main(String[] args) {
        testEmulator();
    }

    public static void testEmulator(){
        //print "BABE"
        String source1 = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.-.+.+++.";

        //prints PI
        String source2 = "<<<<<<<<<<+++++++++++++++++++++++++++++++++++++++++++++++++++><><.--<>---.+++.+++.---.++++.";

        //prints PI
        String source3 = ">>>>-+<<<<<<<<<<++++++++++++++++++++++>+<++++++++++>>---<<+++++++++++++++++++><><.--<>---.+++.+++.---.++++.";

        //do nothing
        String source4 = "[.][+][!][+][.]";

        //print 5
        String source5 = "++>+++<-><->++<>!";

        InputParser inputParser = new InputParser();
        Display display = new Display();
        char[] input = inputParser.inputParsing(source5);

        Emulator emulator = new Emulator(display);
        emulator.load(input);
        emulator.run();


        /*
        char[] code1 = {'+', '+', '+', '-', '-', '!'};
        char[] code2 = {'+', '+', '+', '+', '[', '>', '+', '+', '+', '<', '-', ']', '>', '!'};
        Emulator emulator = new Emulator(code2);

        emulator.runCurrentOpcode();
         */
    }
}
