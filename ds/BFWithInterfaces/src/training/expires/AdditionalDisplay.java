package training.expires;

public class AdditionalDisplay implements IDisplay{

    @Override
    public void putValue(int n) {
        System.err.print((char) n);    //Red print
    }

    @Override
    public void putChar(int n) {
        System.err.print(n);          //Red print
    }

    public void printInput(char[] input){
        for (int i=0; i<input.length; i++){
            System.out.print(input[i]);
        }
        System.out.print("\n");
    }
}
