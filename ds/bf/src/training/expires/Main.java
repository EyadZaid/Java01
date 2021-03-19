package training.expires;

public class Main {

    public static void main(String[] args) {
        testEmulator();
    }

    public static void testEmulator(){
        char[] code1 = {'+', '+', '+', '-', '-', '!'};
        char[] code2 = {'+', '+', '+', '+', '[', '>', '+', '+', '+', '<', '-', ']', '>', '!'};
        Emulator emulator = new Emulator(code2);

        emulator.runCurrentOpcode();


    }
}
