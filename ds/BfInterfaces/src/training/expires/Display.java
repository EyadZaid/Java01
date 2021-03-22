package training.expires;

public class Display implements IDisplay{

    @Override
    public void putValue(int n) {
        System.out.print((char) n);
    }

    @Override
    public void putChar(int n) {
        System.out.print(n);
    }

    public void printInput(char[] input){
        for (int i=0; i<input.length; i++){
            System.out.print(input[i]);
        }
        System.out.print("\n");
    }
}
