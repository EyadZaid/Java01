package training.expires;

public class Main {

    public static void main(String[] args) {
        testEmulator();
    }

    public static void testEmulator(){
        char[] code = {'+', '+', '+', '-', '-', '!'};
        //char[] code = {'+', '+', '+', '+', '[', '>', '+', '+', '+', '<', '-', ']', '.'};
        Emulator emulator = new Emulator(code);

        emulator.runCurrentOpcode();


    }
}
