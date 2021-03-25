package training.expires;

import training.expires.inputOutput.IInput;
import training.expires.inputOutput.IOutput;
import training.expires.manipulation.IEncoder;

public class Telegram {

    private IInput iInput;
    private IOutput iOutput;
    private IEncoder iEncoder;

    public Telegram(IInput iInput, IOutput iOutput, IEncoder iEncoder){
        this.iInput = iInput;
        this.iOutput = iOutput;
        this.iEncoder = iEncoder;
    }

    public void encode(){
        String manipLine, readLine;

        while (!iInput.isEnd()){
            readLine = iInput.readline();
            manipLine = iEncoder.encode(readLine);
            iOutput.write(manipLine);
        }
        iInput.close();
        iOutput.close();
    }


}
