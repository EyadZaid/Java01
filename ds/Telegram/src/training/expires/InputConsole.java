package training.expires;

import java.util.Scanner;

public class InputConsole implements IInputConsole{

    public String input(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        System.out.println("Enter text, end with: new line  .  new line ");
        scanner.useDelimiter("\n.\n");
        text.append(scanner.next());
        return text.toString();
    }
}
