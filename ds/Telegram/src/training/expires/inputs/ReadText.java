package training.expires.inputs;

import java.util.ArrayList;
import java.util.List;

public class ReadText {
    private IInput iInput;

    public ReadText(IInput iInput){
        this.iInput = iInput;
    }

    public List<String> read(){
        List<String> text = new ArrayList<String>();
        while (!iInput.isEnd()){
            text.add(iInput.readline());
        }
        iInput.close();
        return text;
    }
}
