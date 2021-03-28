package training.expires;

import training.expires.inputs.IInput;
import training.expires.outputs.IOutput;
import training.expires.manipulation.IEncoder;

public class Telegram {

    private IInput iInput;
    private IOutput iOutput;
    private IEncoder[] encoders;

    public Telegram(IInput iInput, IOutput iOutput, IEncoder ... encoders){
        this.iInput = iInput;
        this.iOutput = iOutput;
        this.encoders = encoders;
    }


    public void encode(){
        String manipLine, readLine;

        while (!iInput.isEnd()){
            readLine = iInput.readline();
            manipLine = manipulation(readLine);
            iOutput.write(manipLine);
        }
        iInput.close();
        iOutput.close();
    }

    private String manipulation(String line){
        String manipLine = line;
        for (int i=0; i<encoders.length; i++){
            manipLine = encoders[i].encode(manipLine);
        }
        return manipLine;
    }

}
