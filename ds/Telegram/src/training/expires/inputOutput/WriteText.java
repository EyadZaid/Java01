package training.expires.inputOutput;

import java.util.List;

public class WriteText {
    private IOutput iOutput;

    public WriteText(List<String> text){
        for (int i=0; i< text.size(); i++){
            iOutput.write(text.get(i));
        }
        iOutput.close();
    }
}
