package training.expires;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        testEmulator();
    }


    public static void testEmulator(){
        ArrayList<String> sources = new ArrayList<>();

        //print "BABE"
        sources.add("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.-.+.+++.");

        //prints PI
        sources.add("<<<<<<<<<<+++++++++++++++++++++++++++++++++++++++++++++++++++><><.--<>---.+++.+++.---.++++.");

        //prints PI
        sources.add(">>>>-+<<<<<<<<<<++++++++++++++++++++++>+<++++++++++>>---<<+++++++++++++++++++><><.--<>---." +
                "+++.+++.---.++++.");

        //do nothing
        sources.add("[.][+][!][+][.]");

        //print 5
        sources.add("++>+++<-><->++<>!");

        //prints 24
        sources.add("++++++[>++++<-]>!");

        //add 5 + 3 and print result 8
        sources.add("+++++>+++[<+>-]<!");

        //will load 5, 2 into memory and then swap them (you need a debug helper function to see the memory)
        sources.add("+++++>++[>+<-]<[>+<-]>>[<<+>>-]<");

        //prints "Game Over!"
        sources.add("++++++++[>++++>++++++>++++++++>++++++++++>++++++++++++<<<<<-]>>>+++++++.>>+.++++++++++++." +
                "--------.<<<<.>>>-.>+++++++++++++++++.-----------------.+++++++++++++.<<<+.");

        //load 4 and duplicate it two times
        sources.add("++++[>+>+<<-]>>[<<+>>-]<[>+>+<<-]>>[<<+>>-]");

        //prints secret message:
        sources.add("[<!>][<!>][<!>]++++++++[>++++>++++++>++++++++>++++++++++>++++++++++++<<<<<-]" +
                ">>>>------.>+.+++++++++++++++++++++.---------------------.<<<<.>>>>++++++" +
                "+++++++++++++.------------.---.<<<<.>>>--.>++++++++++++++++.-.<<<<+." +
                "[>]<[[-]<]");

        //load 24 into memory (line 1) and then calculate 24/10
        sources.add("++++++[>++++<-]>>+++++++++<[>>>+<<[>+>[-]<<-]>[<+>-]" +
                ">[<<++++++++++>>>+<-]<<-<-]>>>>[<<<<+>>>>-]<<<<>[-]<!");


        InputParser inputParser = new InputParser();
        Display display = new Display();
        char[] input = inputParser.inputParsing(sources.get(8));

        Emulator emulator = new Emulator(display);
        emulator.load(input);
        emulator.displayInput();
        emulator.run();
    }
}
